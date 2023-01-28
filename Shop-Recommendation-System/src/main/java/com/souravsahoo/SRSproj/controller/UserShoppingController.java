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

import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.ShipmentDetails;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.entity.UserCartItem;
import com.souravsahoo.SRSproj.service.UserShopService;

@Controller
@RequestMapping("/user")
public class UserShoppingController {

	@Autowired
	private UserShopService userService;

	private static String userId;
	private String ownerId="sourav";

	public UserShoppingController() {
		System.out.println("========== UserShoppingController constructor call =========");
	}
	
	public static void instantiateUser(String userId) {
		UserShoppingController.userId = userId;
	}

	@RequestMapping("/home")
	public String home( Model model) {
		List<OwnerList> owners = userService.getOwners();
		model.addAttribute("owners", owners);
		
		return "owner-list";
	}

	@GetMapping("/items")
	public String viewListOfItems(Model model) {
		List<ShopItem> itemList = userService.getItems(ownerId);
		model.addAttribute("shopList", itemList);
		model.addAttribute("ownerId", ownerId);
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

		System.out.println("LOG: Username >> " + userId);
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
