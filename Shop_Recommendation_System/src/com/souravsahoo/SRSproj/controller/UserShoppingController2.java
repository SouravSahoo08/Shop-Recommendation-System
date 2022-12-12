package com.souravsahoo.SRSproj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souravsahoo.SRSproj.entity.ShipmentDetails;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;
import com.souravsahoo.SRSproj.service.UserShopService;

@Controller
@RequestMapping("/user-2/home")
public class UserShoppingController2 {

	@Autowired
	private UserShopService userService;

	private String userId = "userid_1";
	private String ownerId = "OWN1";

	public UserShoppingController2() {
		System.out.println("========== UserShoppingController2 constructor call =========");
	}

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

	@RequestMapping("/checkout")
	public String checkOut(/* @RequestParam int userId, @RequestParam int ownerId, */
			@Valid @ModelAttribute(name = "shipmentModel") ShipmentDetails details, BindingResult bindingResult) {

		if (!bindingResult.hasErrors()) {
			List<UserCartItem> cartItems = userService.showCart(userId);
			userService.add_to_orders(cartItems, details, ownerId);
			userService.emptyCart(userId);
			return "checkout-page";
		} else
			return "shipment-details-form";

	}

	@GetMapping("/shipping-details")
	public String addShippingDetails(Model model) {
		model.addAttribute("shipmentModel", new ShipmentDetails());
		return "shipment-details-form";
	}

}
