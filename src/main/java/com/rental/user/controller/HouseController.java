package com.rental.user.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rental.user.domain.Agent;
import com.rental.user.domain.Booking;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseAgent;
import com.rental.user.domain.HouseAgentSample;
import com.rental.user.domain.HouseImage;
import com.rental.user.domain.HouseOwner;
import com.rental.user.domain.HouseRenter;
import com.rental.user.domain.HouseTownship;
import com.rental.user.domain.HouseType;
import com.rental.user.domain.Township;
import com.rental.user.domain.Type;
import com.rental.user.domain.User;
import com.rental.user.service.AgentService;
import com.rental.user.service.HouseAgentSampleService;
import com.rental.user.service.HouseService;
import com.rental.user.service.TownshipService;
import com.rental.user.service.TypeService;
import com.rental.user.service.UserService;

@Controller
public class HouseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private TownshipService townshipService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private HouseAgentSampleService houseAgentSampleService;
	
	@RequestMapping("/forRent")
	private String forRent(Model model,Principal principal) {
		
		User user = userService.findByUsername(principal.getName());
		
		if(user == null) {
			return "login";
		}
		
		House house = new House();
		Township township = new Township();
		Type type = new Type();
		 
		List<Township> townshipList = townshipService.findAll();
		List<String> townshipName = new ArrayList<String>();
		
		for(int i=0; i<townshipList.size();i++) {
			townshipName.add(townshipList.get(i).getTownshipName());
		}
		
		System.out.println(township); 
		
		List<Type> typeList = typeService.findAll();
		List<String> typeName = new ArrayList<String>();
		
		for(int i=0; i<typeList.size();i++) {
			typeName.add(typeList.get(i).getTypeName());
		}
		
		model.addAttribute("user", user);
		model.addAttribute("house", house);
		model.addAttribute("type", type);
		model.addAttribute("typeName", typeName);
		model.addAttribute("townshipName", townshipName);
		model.addAttribute("township", township);
		
		return "forRent";
		
	}
	
	@PostMapping("/forRent")
	private String postForRent(@ModelAttribute("user") User user, @ModelAttribute("house") House house, @ModelAttribute("type") Type type,
			@ModelAttribute("township") Township township, Model model, Principal principal) throws IOException {
		
		User currentUser = userService.findByUsername(principal.getName());
		
		if(!currentUser.getUserId().equals(user.getUserId())) {
			
			return "badRequestPage";
			
		}
		
		System.out.println(currentUser);
		
		Township township1 = townshipService.findByTownshipName(township.getTownshipName());
		
		HouseTownship ht = new HouseTownship();
		ht.setTownship(township1);
		ht.setHouse(house);
		
		System.out.println("ht "+ht);
		
		Type type1 = typeService.findByTypeName(type.getTypeName());
		
		HouseType htype = new HouseType();
		htype.setHouse(house);
		htype.setType(type1);
		
		System.out.println("htype "+htype);
		
		HouseOwner ho = new HouseOwner();
		ho.setHouse(house);
		ho.setUser(currentUser);
		ho.setEnabled(false);
		
		HouseRenter hr = new HouseRenter();
		hr.setHouse(house);
		hr.setUser(currentUser);
		hr.setEnabled(false);
		
		
		String facilities = house.getFacilities();
		System.out.println("facilities "+facilities);
		
		String floor = house.getFloor();
		System.out.println("floor "+floor);
		
		house.setFloor(floor);
		house.setFacilities(facilities);
		house.setHouseTownship(ht);
		house.setHouseType(htype);
		house.setHouseOwner(ho);
		house.setHouseRenter(hr);
		//house.setHouseAgent(houseAgent);
		house.setEnabled(false);
		
		MultipartFile[] houseImages = new MultipartFile[5];
		MultipartFile houseImage1 = house.getHouseImage1();
		MultipartFile houseImage2 = house.getHouseImage2();
		MultipartFile houseImage3 = house.getHouseImage3();
		MultipartFile houseImage4 = house.getHouseImage4();
		MultipartFile houseImage5 = house.getHouseImage5();
		
		int count=0;
		try {
			
			if(!houseImage1.equals(null)) {
				houseImages[0] = houseImage1;
				System.out.println("house1"+houseImages[0]);
				count++;
			}
			
		}catch(Exception e) {
			System.out.println("houseImage1 is empty");
		}
		
		try {
			
			if(!houseImage2.equals(null)) {
				houseImages[1] = houseImage2;
				System.out.println("house2"+houseImages[1]);
				count++;
			}
			
		}catch(Exception e) {
			System.out.println("houseImage2 is empty");
		}
		
		try {
			
			if(!houseImage3.equals(null)) {
				houseImages[2] = houseImage3;
				System.out.println("house3"+houseImages[2]);
				count++;
			}
			
		}catch(Exception e) {
			System.out.println("houseImage3 is empty");
		}
		
		try {
			
			if(!houseImage4.equals(null)) {
				houseImages[3] = houseImage4;
				System.out.println("house4"+houseImages[3]);
				count++;
			}
			
		}catch(Exception e) {
			System.out.println("houseImage4 is empty");
		}
		
		try {
			
			if(!houseImage5.equals(null)) {
				houseImages[4] = houseImage5;
				System.out.println("house5"+houseImages[4]);
				count++;
			}
			
		}catch(Exception e) {
			System.out.println("houseImage5 is empty");
		}
		
		Set<HouseImage> houseImg = new HashSet<HouseImage>();
		
		for(int i=0; i<count; i++) {
			if(!houseImages[i].equals(null)) {
				System.out.println("count"+i);
				
				HouseImage h = new HouseImage();
				h.setHouse(house);
				h.setImageName(i+".jpg");
				houseImg.add(h);
			}
		}
		
		house.setHouseImages(houseImg);
		
		House savedHouse = houseService.saveHouse(house);
		
		List<Agent> agentList = agentService.findAll();
		
		HouseAgentSample houseAgentSample = new HouseAgentSample();
		houseAgentSample.setHouseId(house.getHouseId());
		houseAgentSample.setAgentId(agentList.get(0).getId());
		
		houseAgentSampleService.save(houseAgentSample);
		
		String img[] = new String[5];
		
		for(int i=0; i<count; i++) {
			
			if(!houseImages[i].equals(null)) {
				
				System.out.println("count"+i);
				
				byte[] bytes = houseImages[i].getBytes();
				String name = savedHouse.getHouseId()+"_"+i+".jpg";
				
				img[i]=name;
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/images/house/"+name))
						);
				stream.write(bytes);
				stream.close();
				
			}
			
		}
		
		houseService.saveHouseImage(savedHouse, houseImg);
		
		User user1= userService.findByUsername(principal.getName());
		
		user1.setUserId(user1.getUserId());
		user1.setRent(0);
		user1.setOwned(0);
		
		userService.saveUser(user1);
		
		
		House house1 = new House();
		Township townshipFor = new Township();
		Type typeFor = new Type();
		 
		List<Township> townshipList = townshipService.findAll();
		List<String> townshipName = new ArrayList<String>();
		
		for(int i=0; i<townshipList.size();i++) {
			townshipName.add(townshipList.get(i).getTownshipName());
		}
		 
		
		List<Type> typeList = typeService.findAll();
		List<String> typeName = new ArrayList<String>();
		
		for(int i=0; i<typeList.size();i++) {
			typeName.add(typeList.get(i).getTypeName());
		}
		
		model.addAttribute("user", currentUser);
		model.addAttribute("house", house1);
		model.addAttribute("type", typeFor);
		model.addAttribute("typeName", typeName);
		model.addAttribute("townshipName", townshipName);
		model.addAttribute("township", townshipFor);
		
		model.addAttribute("successForm", true);
		
		return "forRent";
	}

	@RequestMapping("/booking")
	private String forBook(Model model,Principal principal,@RequestParam("id")Long id) {
		
		User user = userService.findByUsername(principal.getName());
		
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		model.addAttribute("houseId",id);
		model.addAttribute("userName",user.getUsername());
//
//		List<House> houseList=houseService.findAll();
//		List<String> houseName = new ArrayList<String>();
//		for(int i=0; i<houseList.size();i++) {
//			houseName.add(houseList.get(i).getFacilities());
//		}
//		model.addAttribute("houseList",houseName);
//		
		return "booking";
		
	}
	
}
