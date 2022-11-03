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

import com.souravsahoo.SRSproj.entity.ShopItem;
import com.souravsahoo.SRSproj.service.ShopService;

@Controller
@RequestMapping("/home")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/items")
	public String viewListOfItems(Model model) {

		List<ShopItem> itemList = shopService.getItems();
		model.addAttribute("shopList", itemList);

		return "list-item-view";
	}

	@GetMapping("/addItemForm")
	public String addItemForm(Model model) {
		model.addAttribute("item", new ShopItem());
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
		if (bindingResult.hasErrors()) {
			System.out.println("errors");
			return "add-item-form";
		} else {
			System.out.println("WTF!!!!!!!!");
			shopService.saveItem(shopItem);
			return "redirect:/home/items";
		}
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

		ShopItem itemDetail = shopService.getItemDetail(itemId);
		System.out.println(itemDetail.toString());

		model.addAttribute("item", itemDetail);
		return "update-item-form";
	}

}
