package com.souravsahoo.SRSproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souravsahoo.SRSproj.entity.OwnerList;

@Controller
@RequestMapping("/")
public class SystemHomepageController {

	@RequestMapping("/home-page")
	public String homePage() {
		return "home-page";
	}
	
	@RequestMapping("/shop-register")
	public String register(Model model) {
		model.addAttribute("shop-registration-details", new OwnerList());
		return "shop-register";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAllAttributes("credential",new UserList());
		return "login";
	}
}
