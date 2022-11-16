package com.souravsahoo.SRSproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	
	@PostMapping("/addOrder")
	public String addOrder(
			@RequestParam int userId,
			@RequestParam int ownerId,
			@RequestParam int itemId,
			Model model) { 
		
		return "checkout-page";
	}
	
	@RequestMapping("/checkout")
	public String checkOut() {
		return null;
	}
}
