package com.souravsahoo.SRSproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;
import com.souravsahoo.SRSproj.service.UserShopService;

@Controller
@RequestMapping("/user/home")
public class UserShoppingController {

	@Autowired
	private UserShopService userService;
	
	private String userId = "userid_1";
	private String ownerId = "OWN1";

	@RequestMapping("/items")
	public String viewListOfItems(Model model) {

		List<ShopItem> itemList = userService.getItems(ownerId);
		model.addAttribute("shopList", itemList);

		return "user-item-list";
	}
	
	@RequestMapping("/cart")
	public String displayShoppingCart(Model model) {
		
		List<UserCartItem> cartItems = userService.showCart(userId);
		model.addAttribute("cartItems", cartItems);
		return "shoping-cart";
	}

	@GetMapping("/addItem")
	public String addToCart(@RequestParam("itemId") int itemId) {

		ShopItem itemDetail = userService.getItemDetail(itemId, ownerId);
		System.out.println("UserShopController: /cart -> itemDetail ====> " + itemDetail);

		userService.addItemToCart(itemDetail, userId);
		return "redirect:cart";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam("itemId") int itemId) {

		userService.removeItem(userId, itemId);

		return "redirect:cart";
	}
	
	@RequestMapping("emptyCart")
	public String emptyCart() {
		userService.emptyCart(userId);
		return "redirect:cart";
	}

}
