package com.souravsahoo.SRSproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.service.UserShopService;

@Controller
@RequestMapping("/user/home")
public class UserShoppingController {

	@Autowired
	private UserShopService userService;
	
	@RequestMapping("/items")
	public String viewListOfItems(Model model) {

		List<ShopItem> itemList = userService.getItems();
		model.addAttribute("shopList", itemList);

		return "user-item-list";
	}
}
