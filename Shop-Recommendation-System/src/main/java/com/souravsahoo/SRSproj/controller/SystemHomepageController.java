package com.souravsahoo.SRSproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.UserList;
import com.souravsahoo.SRSproj.service.OwnerUserInfo_Service;

@Controller
@RequestMapping /* ("/") */
public class SystemHomepageController {

	@Autowired
	private OwnerUserInfo_Service ownerUserInfo;

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "loginpage";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
	@RequestMapping("/home-page")
	public String homePage() {
		return "home-page";
	}

	@RequestMapping("/shop-register")
	public String registerOwner(Model model) {
		model.addAttribute("shop-registration-details", new OwnerList());
		return "shop-register";
	}

	@PostMapping("/saveOwner")
	public String saveOwner(@ModelAttribute("shop-registration-details") OwnerList ownerList) {
		ownerUserInfo.saveOwnerDetails(ownerList);
		return "redirect:/home-page";
	}

	@RequestMapping("/user-register")
	public String registerUser(Model model) {
		model.addAttribute("customer-registration-details", new UserList());
		return "user-register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("customer-registration-details") UserList userList) {
		ownerUserInfo.saveUserDetails(userList);
		return "redirect:/home-page";
	}
}
