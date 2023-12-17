package com.rental.user.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseTownship;
import com.rental.user.domain.Township;
import com.rental.user.service.HouseService;
import com.rental.user.service.TownshipService;

@Controller
public class SearchController { 

	@Autowired 
	private HouseService houseService;
	
	@Autowired
	private TownshipService townshipService;
	 
	@RequestMapping("/searchByPrice")
	private String searchByPrice(@RequestParam("price") Double price,Model model) {
		
		if(price == 100000.0) {
			for (Double i = (double) 0; i <= 100000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		if(price == 200000.0) {
			for (Double i = (double) 0; i <= 200000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		}
		
		if(price == 300000.0) {
			for (Double i = (double) 0; i <= 300000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		}
		
		if(price == 400000.0) {
			for (Double i = (double) 0; i <= 400000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		}
		
		if(price == 500000.0) {
			for (Double i = (double) 0; i <= 500000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		if(price == 600000.0) {
			for (Double i = (double) 0; i <= 600000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		if(price == 700000.0) {
			for (Double i = (double) 0; i <= 700000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		if(price == 800000.0) {
			for (Double i = (double) 0; i <= 800000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		if(price == 900000.0) {
			for (Double i = (double) 0; i <= 900000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		if(price == 1000000.0) {
			for (Double i = (double) 0; i <= 1000000.0; i+=10000) {
				List<House> houseList = houseService.findByPrice(i);
				model.addAttribute("houseList", houseList);
			}
		} 
		
		return "listing";
	}
	
	@RequestMapping("/searchByTownship")
	private String searchByTownship(@RequestParam("townshipName") String townshipName,Principal principal,Model model) {
		
		Township township = townshipService.findByTownshipName(townshipName);
		
		Set<HouseTownship> houseTownshipSet = township.getHouseTownship();
		
		String classActiveTownship = "active"+townshipName;
		
		classActiveTownship = classActiveTownship.replaceAll("\\s+", "");
		classActiveTownship = classActiveTownship .replaceAll("&+", "");
		
		model.addAttribute("classActiveTownship", classActiveTownship);
		
		List<House> houseList = new ArrayList<>();
		
		for(HouseTownship houseTownship : houseTownshipSet) {
			
			House house = houseTownship.getHouse();
			houseList.add(house);
			model.addAttribute("houseList", houseList);
		}
		
		return "listing";
	}

}
