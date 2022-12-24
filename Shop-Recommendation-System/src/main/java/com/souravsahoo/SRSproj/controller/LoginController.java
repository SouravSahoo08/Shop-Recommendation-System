package com.souravsahoo.SRSproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		// return "plain-login";

		return "loginpage";
		
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		
		// return "plain-login";
		
		return "access-denied";
		
	}
	
	
}
