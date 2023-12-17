package com.rental.user.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ALL Members
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.user.domain.Agent;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseAgentSample;
import com.rental.user.domain.HouseImage;
import com.rental.user.domain.HouseOwner;
import com.rental.user.domain.HouseRenter;
import com.rental.user.domain.HouseTownship;
import com.rental.user.domain.Role;
import com.rental.user.domain.User;
import com.rental.user.domain.UserRole;
import com.rental.user.service.AgentService;
import com.rental.user.service.HouseAgentSampleService;
import com.rental.user.service.HouseAgentService;
import com.rental.user.service.HouseImageService;
import com.rental.user.service.HouseOwnerService;
import com.rental.user.service.HouseRenterService;
import com.rental.user.service.HouseService;
import com.rental.user.service.UserService;
import com.rental.user.utility.MailConstructor;
import com.rental.user.utility.SecurityUtility;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private HouseImageService houseImageService;
	
	@Autowired
	private HouseAgentService houseAgentService;
	
	@Autowired
	private HouseAgentSampleService houseAgentSampleService;
	
	@Autowired
	private HouseRenterService houseRenterService;
	
	@Autowired
	private HouseOwnerService houseOwnerService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("activeLink", "Home");
		HouseTownship houseTownship = new HouseTownship();
		
		model.addAttribute("houseTownship",houseTownship);
		return "index";
	}
	
	@RequestMapping("/index")
	public String index1() {
		return "index";
	}
	
	
	//Wutt Yee Tun
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	//Khin Pyae Pyae Phyo
	@RequestMapping("/listing")
	public String bookShelf(Model model,Principal principal) {
//		if(principal != null) {
//			String username = principal.getName();
//			User user = userService.findByUsername(username);
//			model.addAttribute("user",user);
//		}
	
		List<House> houseEnable = new ArrayList<House>();
		List<House> houseList = houseService.findAll();
		
		for(House house:houseList) {
			
			if(house.getEnabled()) {
				
				
				if(!house.getHouseRenter().getEnabled()) {
					houseEnable.add(house);
				}
			}
			
		}
		
		model.addAttribute("houseList",houseEnable);
		
		
		
		return "listing";
	}
	
	//Lin Lae Win Wah
	@RequestMapping("/about")
	public String about(Model model) {
		List<Agent> agentList=agentService.findAll();
		model.addAttribute("agentList",agentList);
		model.addAttribute("activeLink","About");
		return "about";
	}
	
	@RequestMapping("/agentProfile")
	public String agentProfile(@RequestParam("id") Long id,Model model) {
		
		Agent agent = agentService.findById(id);
		model.addAttribute("agent",agent);
		
		return "agentProfile";
	}
	
	@RequestMapping("/myProfile")
	public String myProfile(Model model, Principal principal) {
		
		User user = userService.findByUsername(principal.getName());
		
		int rentCount =0;
		int ownCount =0;
		
		List<House> houseList = houseService.findAll();
		
		
		
		for(House h:houseList) {
			
			HouseOwner ho = houseOwnerService.findByHouse(h);
			
			if(ho.getUser().getUserId().equals(user.getUserId())) {
				if(ho.getEnabled()) {
					ownCount++;
				}
			}
			
			
		}
		
//		List<HouseOwner> houseOwnerList = houseOwnerService.findByUser(user);
//		
//		for(int i=0;i<houseOwnerList.size();i++) {
//			
//			System.out.println("houseowner userid "+houseOwnerList.get(i).getUser().getUserId());
//			
//			if(houseOwnerList.get(i).getUser().getUserId().equals(user.getUserId())) {
//				if(houseOwnerList.get(i).getEnabled()) {
//					
//					ownCount++;
//					
//				}
//			}
//			
//			//houseRenterList.get(i).getHouse().getHouseId();
//			
//			
//			
//		}
		
		System.out.println("own "+ownCount);
		
		System.out.println("user id "+user.getUserId());
		
		
		List<HouseRenter> houseRenterList = houseRenterService.findAll();
		
		for(int i=0;i<houseRenterList.size();i++) {
			
			//System.out.println("housrenter userid "+houseRenterList.get(i).getUser().getUserId());
			
			if(houseRenterList.get(i).getUser().getUserId().equals(user.getUserId())) {
				if(houseRenterList.get(i).getEnabled()) {
					
					rentCount++;
					
				}
			}
			
			//houseRenterList.get(i).getHouse().getHouseId();
			
			
			
		}
		
		System.out.println("rent "+rentCount);
		
		model.addAttribute("user", user);
		model.addAttribute("rentCount", rentCount);
		model.addAttribute("ownCount", ownCount);
		
		return "myProfile";
	}
	
	//ThetHninSu
	@PostMapping("/updateUserInfo")
	public String updateUserInfo(@ModelAttribute("user") User user,@ModelAttribute("newPassword") String newPassword,
			@ModelAttribute("currentPassword") String currentPassword,Model model,Principal principal) throws Exception {
		
		User user1 = userService.findByUsername(principal.getName());
		User currentUser = userService.findById(user.getUserId());
		
		if(currentUser == null) {
			throw new Exception("User not Exist");
		}
		
		
		if(userService.findByUsername(user.getUsername()) != null) {
			if(userService.findByUsername(user.getUsername()).getUserId() != currentUser.getUserId()) {
				model.addAttribute("usernameExists",true);
				model.addAttribute("classActiveEdit",true);
				
				return "myProfile";
			}
		}
		
		if(userService.findByEmail(user.getEmail()) != null) {
			if(userService.findByEmail(user.getEmail()).getUserId() != currentUser.getUserId()) {
				model.addAttribute("emailExists", true);
				model.addAttribute("classActiveEdit",true);
				
				return "myProfile";
			}
		}		if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
			
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoderInSU();
			
			String dbPassword = currentUser.getPassword();
			
			if(currentPassword.equals(dbPassword)) {
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			}else {
				model.addAttribute("incorrectPassword", true);
				model.addAttribute("classActiveEdit",true);
				return "myProfile";
			}
		}
		
		String regexName = "^[A-Za-z]{3,29}$";
		String regexUsername = "^[A-Za-z]\\w{2,29}$";
		String regexPhone = "^\\d{11}$";
		
		Pattern pUsername = Pattern.compile(regexUsername);
		Pattern pName = Pattern.compile(regexName);
		Pattern pPhone = Pattern.compile(regexPhone);
		
		Matcher mUsername = pUsername.matcher(user.getUsername());
		Matcher mFname = pName.matcher(user.getFirstName());
		Matcher mLname = pName.matcher(user.getLastName());
		Matcher mPhone = pPhone.matcher(user.getPhoneNo());
	
			int rentCount =0;
			int ownCount =0;
			
			List<House> houseList = houseService.findAll();
			
			
			
			for(House h:houseList) {
				
				HouseOwner ho = houseOwnerService.findByHouse(h);
				
				if(ho.getUser().getUserId().equals(user.getUserId())) {
					if(ho.getEnabled()) {
						ownCount++;
					}
				}
				
				
			}
			
			List<HouseRenter> houseRenterList = houseRenterService.findAll();
			
			for(int i=0;i<houseRenterList.size();i++) {
				
				//System.out.println("housrenter userid "+houseRenterList.get(i).getUser().getUserId());
				
				if(houseRenterList.get(i).getUser().getUserId().equals(user.getUserId())) {
					if(houseRenterList.get(i).getEnabled()) {
						
						rentCount++;
						
					}
				}
				
				//houseRenterList.get(i).getHouse().getHouseId();
				
				
				
			}
			
			System.out.println("rent "+rentCount);            model.addAttribute("rentCount", rentCount);
            model.addAttribute("ownCount", ownCount);
			
			if(mFname.matches()) {
				if(mLname.matches()) {
					if(mUsername.matches()) {
						if(mPhone.matches()) {
							currentUser.setFirstName(user.getFirstName());
							currentUser.setLastName(user.getLastName());
							currentUser.setPhoneNo(user.getPhoneNo());
							currentUser.setUsername(user.getUsername());
							
							userService.updateUser(currentUser);
							
							model.addAttribute("updateUserInfo",true);
							model.addAttribute("user",currentUser);
							model.addAttribute("classActiveEdit",true);
						}else {
							model.addAttribute("user",currentUser);
							model.addAttribute("classActiveEdit",true);
							model.addAttribute("phonePattern", true);
						}
					}else {
						model.addAttribute("user",currentUser);
						model.addAttribute("classActiveEdit",true);
						model.addAttribute("usernamePattern", true);
					}
				}else {
					model.addAttribute("user",currentUser);
					model.addAttribute("classActiveEdit",true);
					model.addAttribute("lnamePattern", true);
				}
			}else {
				model.addAttribute("user",currentUser);
				model.addAttribute("classActiveEdit",true);
				model.addAttribute("fnamePattern", true);
			}
		
		return "myProfile";
	}
	
	//Khin Pyae Pyae Phyo
	@RequestMapping("/propertySingle")
	public String propertySingle(@RequestParam("id") Long houseId, Model model) {
		
		List<House> houseList = houseService.findAll();
		
		for(House h:houseList) {
			
			if(h.getHouseId().equals(houseId)) {
				
				if(h.getHouseRenter().getEnabled()) {
					
					model.addAttribute("house",h);
					
				}
				model.addAttribute("house",h);
				
			}
			
		}
		//model.addAttribute("house",houseList);
		
		House house = houseService.findById(houseId);
		
		List<HouseImage> houseImgList = houseImageService.findByHouse(house);
		
		model.addAttribute("houseImgList",houseImgList);
		
		//model.addAttribute("house",house);
		
		for(HouseImage houseImg : houseImgList) {
			System.out.println(houseImg.getImageName());
		}
		System.out.println(houseImgList);
		
		HouseAgentSample ha= houseAgentSampleService.findByHouseId(houseId);
		
		Agent agent = agentService.findById(ha.getAgentId());
		
		model.addAttribute("agent", agent);
		
		return "property-single";
	}
	
	
	
	//ThetHninSu
	@RequestMapping("/houseBooking")
	public String houseBooking() {
		return "houseBooking";
	}
	
	//Wutt Yee Tun
	@RequestMapping("/signup")
	public String signup(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "signup";
	}
	
	//Wutt Yee Tun
	@PostMapping("/signup")
	public String postSignUp(HttpServletRequest request,@ModelAttribute("user") User user, Model model) {
		
		if(userService.findByEmail(user.getEmail()) != null) {
			model.addAttribute("emailExists", true);
			return "signup";
		}
		String conPass = user.getConfirmPassword();
		if(!conPass.equals(user.getPassword())) {
			model.addAttribute("passNotSame", true);
			return "signup";
		}
		
		User user1 = new User();
		user1.setEmail(user.getEmail());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setUsername(user.getUsername());
		
		String password = user.getPassword();
		String encryptedPassword = SecurityUtility.passwordEncoderInSU().encode(password);
		
		user1.setPassword(encryptedPassword);
		user1.setPhoneNo(user.getPhoneNo());
		user1.setRent(0);
		user1.setOwned(0);
		
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		
		Set<UserRole>  userRole = new HashSet<>();
		userRole.add(new UserRole(user1,role));
		
//		userRole.setUser(user1);
//		userRole.setRole(role);
		
		userService.createUser(user1, userRole);
		
		model.addAttribute("createAccSuccess", true);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		SimpleMailMessage sentEmail = mailConstructor.constructSignUpEmail(appUrl, request.getLocale(), user1.getEmail(), "Dream Space Agency - New User");
				
		mailSender.send(sentEmail);
		
		return "login";
		
	}
	//ThetHninSu
			@SuppressWarnings("null")
			@RequestMapping("/ownHouseList")
			public String ownHouseList(Model model,Principal principal) {
				
				User user = userService.findByUsername(principal.getName());
				List<HouseOwner> houseOwnerList = user.getHouseOwnerList();
				
				for(HouseOwner houseOwner : houseOwnerList) {
					
					House house = new House();
					if(houseOwner.getHouse().getHouseId() == house.getHouseId()) {
						
						House house1 = houseOwner.getHouse();
						do {
							List<House> houseList = null;
							houseList.add(house1);
							model.addAttribute("houseList", houseList);
						} while (house1 != null);
					}
				}
				return "ownHouseList";
			}
	
	
}
