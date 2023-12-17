package com.rental.user.controller;

import java.security.Principal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rental.user.domain.Booking;
import com.rental.user.domain.House;
import com.rental.user.domain.User;
import com.rental.user.service.BookingService;
import com.rental.user.service.UserService;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/houseBooking")
	public String houseBooking(Model model,@RequestParam("id")Long id) {
		
		Long in = (long) 1;
		Booking booking = new Booking();
		booking.setHouseId(id);
		System.out.println(id);
		model.addAttribute("booking", booking);
		model.addAttribute("houseId",id);
		return "booking";  
	}   
	 
	@PostMapping("/houseBooking")
	public String houseBookingPost(@ModelAttribute("booking") Booking booking,Model model,Principal principal) {
//		String regexName = "^[A-Za-z]{3,29}$";
//		String regexPhone = "^\\d{10}$";
//		String regexEmail = "^(.+)@(.+)$";
//		
//		Pattern pName = Pattern.compile(regexName);
//		Pattern pPhone = Pattern.compile(regexPhone);
//		Pattern pEmail = Pattern.compile(regexEmail);
//		
//		Matcher mname = pName.matcher(booking.getCustomerName());
//		Matcher mPhone = pPhone.matcher(booking.getPhoneNo());
//		Matcher mEmail = pEmail.matcher(booking.getEmail());
//		
//		Booking booking1 = new Booking();
//		
//		if(mname.matches() && mPhone.matches() && mEmail.matches()) {
//			
		Booking booking1 = new Booking();
		
			booking1.setCustomerName(booking.getCustomerName());
			booking1.setPhoneNo(booking.getPhoneNo());
			booking1.setEmail(booking.getEmail());
			booking1.setExpectedTime(booking.getExpectedTime());
			booking1.setExpectedDate(booking.getExpectedDate());
			booking1.setApprove(false);
			booking1.setHouseId(booking.getHouseId());
//		}else {
//			model.addAttribute("patternIncorrect", true);
//		}
		
		
		User user = userService.findByUsername(principal.getName());
		booking1.setUserName(user.getUsername());
		
		System.out.println(booking1.getHouseId());
		bookingService.saveBooking(booking1);
		
		return "redirect:/"; 
		
	}
}
