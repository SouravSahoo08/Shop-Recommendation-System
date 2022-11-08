package com.souravsahoo.SRSproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	// @Qualifier("userShopServiceImpl")
	private UserShopService userService;

	@RequestMapping("/items")
	public String viewListOfItems(Model model) {

		List<ShopItem> itemList = userService.getItems();
		model.addAttribute("shopList", itemList);

		return "user-item-list";
	}

	@GetMapping("/cart")
	public String cart(@RequestParam("itemId") int itemId, Model model) {

		ShopItem itemDetail = userService.getItemDetail(itemId);
		System.out.println("UserShopController: /cart -> itemDetail ====> " + itemDetail);

		userService.addItemToCart(itemDetail, "userid_1");
		List<UserCartItem> cartItems = userService.getCartItems();

		System.out.println("UserShopController: /cart -> cartItems ====> " + cartItems);

		model.addAttribute("cartItems", cartItems);
		return "shoping-cart";
	}

}
