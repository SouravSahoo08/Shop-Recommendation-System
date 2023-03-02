package com.souravsahoo.SRSproj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.service.ShopService;
import com.souravsahoo.SRSproj.service.UserAuthService;

@Controller
@RequestMapping("/owner")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@Autowired
	private UserAuthService userAuthService;

	private static String ownerId;

	public ShopController() {
		System.out.println("========== shop controller constructor call =========");
	}

	// called by AopManager
	public static void instantiateUser(String ownerId) {
		System.out.println("LOG: ownerId>> " + ownerId);
		ShopController.ownerId = ownerId;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/home")
	public String ownerHomePage(Model model) {
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "owner-home";
	}

	@RequestMapping("/items")
	public String viewListOfItems(Model model) {
		System.out.println("LOG: Owner name >> " + ownerId);
		List<ShopItem> itemList = shopService.getItems(ownerId);
		model.addAttribute("shopList", itemList);
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "list-item-view";
	}

	@GetMapping("/addItemForm")
	public String addItemForm(Model model) {
		model.addAttribute("item", new ShopItem());
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "add-item-form";
	}

	/**
	 * Saves new entry to db or updates the object if previous id is passed
	 * 
	 * @param shopItem
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/saveItem")
	public String saveItem(@Valid @ModelAttribute("item") ShopItem shopItem, BindingResult bindingResult) {

		System.out.println(shopItem);

		if (bindingResult.hasErrors()) {
			System.out.println("found error");
			return "add-item-form";
		}
		System.out.println("WTF!!!!!!!!");

		shopItem.setOwnerId(ownerId);
		shopService.saveItem(shopItem);
		return "redirect:/owner/items";

	}

	/**
	 * Using id from the request parameter, get the details of item and associates
	 * it to the @ShopItem object for pre-population in updation form page
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/showItem")
	public String showItem(HttpServletRequest request, Model model) {
		String idParam = request.getParameter("id");
		int itemId = Integer.parseInt(idParam);
		System.out.println(itemId);

		ShopItem itemDetail = shopService.getItemDetail(itemId, ownerId);
		System.out.println(itemDetail.toString());

		model.addAttribute("item", itemDetail);
		return "update-item-form";
	}

	@GetMapping("removeItem")
	public String removeItem(@RequestParam("id") int itemId, Model model) {

		// ShopItem itemDetail = shopService.getItemDetail(itemId);
		shopService.deleteItem(itemId, ownerId);
		return "redirect:/owner/items";
	}

	@GetMapping("search")
	public String searchItems(@RequestParam("searchItemName") String searchItemName, Model model) {
		List<ShopItem> shopItems = shopService.searchItem(searchItemName.toLowerCase(), ownerId);
		model.addAttribute("shopList", shopItems);
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "list-item-view";
	}

	private OwnerList getOwner() {
		OwnerList owner = userAuthService.findByOwnerName(ownerId);
		return owner;
	}
}
