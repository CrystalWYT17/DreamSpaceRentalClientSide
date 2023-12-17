package com.rental.user.controller;

import java.security.Principal;
import java.util.ArrayList;

/**
 * @author Khin Pyae Paye Phyo
 */

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseType;
import com.rental.user.domain.Type;
import com.rental.user.service.HouseService;
import com.rental.user.service.HouseTypeService;
import com.rental.user.service.TypeService;


@Controller
public class TypeSearchController { 

	@Autowired
	private HouseService houseService;

	
	@Autowired
	private HouseTypeService houseTypeService;
	
	@Autowired
	private TypeService typeService;
	 
	
	@RequestMapping("/searchByType")
	private String searchByType(@RequestParam("typeName") String typeName,Principal principal,Model model) {
		
		
		Type type = typeService.findBytypeName(typeName);
		
		Set<HouseType> houseTypeList = type.getHouseType();
		
		
		String classActiveType  = "active"+typeName;
		
		
		classActiveType = classActiveType .replaceAll("\\s+", "");
		classActiveType = classActiveType .replaceAll("&+", "");
		
		model.addAttribute("classActiveType", classActiveType);
		
		
		
		List<House> houseList = new ArrayList<>();
for(HouseType houseType : houseTypeList) {
			
			House house = houseType.getHouse();
			
			//List<House> houseList = houseService.findByHouseType(houseType);
			
			
			houseList.add(house);
			
			model.addAttribute("houseList", houseList);
			
			
		}
		


		
		
			
			
			return "listing";
}
		
	
	
	
}
