package com.souravsahoo.SRSproj.controller;

import java.util.ArrayList;
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

import com.souravsahoo.SRSproj.entity.CombinedDataModel;
import com.souravsahoo.SRSproj.entity.OwnerCartItem;
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

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	/**
	 * shows homepage of shopkeeper accont
	 * 
	 * @param model
	 * @return owner-home jsp page
	 */
	@RequestMapping("/home")
	public String ownerHomePage(Model model) {
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "owner-home";
	}

	/**
	 * shows list of available items
	 * 
	 * @param model
	 * @return list-item-view jsp page
	 */
	@RequestMapping("/items")
	public String viewListOfItems(Model model) {
		System.out.println("LOG: Owner name >> " + ownerId);
		List<ShopItem> itemList = shopService.getItems(ownerId);
		model.addAttribute("shopList", itemList);
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "list-item-view";
	}

	/**
	 * Shows add item form page
	 * 
	 * @param model
	 * @return add-item-form jsp page
	 */
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
	public String saveItem(@Valid @ModelAttribute("item") ShopItem shopItem, BindingResult bindingResult, Model model) {

		System.out.println(shopItem);

		if (bindingResult.hasErrors()) {
			System.out.println("found error");
			model.addAttribute("ownerName", getOwner().getOwnerName());
			return "add-item-form";
		}

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
		model.addAttribute("ownerName", getOwner().getOwnerName());
		return "update-item-form";
	}

	/**
	 * removes item from the stock
	 * 
	 * @param itemId
	 * @param model
	 * @return stock item view page
	 */
	@GetMapping("removeItem")
	public String removeItem(@RequestParam("id") int itemId, Model model) {
		shopService.deleteItem(itemId, ownerId);
		return "redirect:/owner/items";
	}

	/**
	 * searches the particular item from the available stock
	 * 
	 * @param searchItemName
	 * @param page
	 * @param model
	 * @return view page according to the page parameter passed.
	 */
	@GetMapping("search")
	public String searchItems(@RequestParam("searchItemName") String searchItemName,
			@RequestParam(value = "page", required = false) String page, Model model) {
		List<ShopItem> shopItems = shopService.searchItem(searchItemName.toLowerCase(), ownerId);
		model.addAttribute("shopList", shopItems);
		model.addAttribute("ownerName", getOwner().getOwnerName());

		if ("customer-outlet-view".equals(page)) {
			manage_combinedModel(model, shopItems);
			return "customer-outlet-view";
		} else {
			return "list-item-view";
		}
	}

	/* *********** customer outlet functionalities ************ */

	/**
	 * Shows customer outlet page
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("customer-outlet")
	public String customerOutlet(Model model) {
		model.addAttribute("ownerName", getOwner().getOwnerName());

		List<ShopItem> itemList = shopService.getItems(ownerId);
		manage_combinedModel(model, itemList);
		return "customer-outlet-view";
	}

	/**
	 * adds item to cart of customer outlet
	 * 
	 * @param itemId
	 * @return customer-outlet jsp-page
	 */
	@GetMapping("/cart-addItem")
	public String addToCart(@RequestParam("itemId") int itemId) {

		ShopItem itemDetail = shopService.getItemDetail(itemId, ownerId);
		System.out.println("ShopController: /cart -> itemDetail ====> " + itemDetail);

		shopService.addItemToCart(itemDetail, ownerId);
		return "redirect:/owner/customer-outlet";
	}

	/**
	 * removes item from cart of customer outlet
	 * 
	 * @param itemId
	 * @return customer-outlet jsp-page
	 */
	@GetMapping("cart-removeItem")
	public String removeItemFromCart(@RequestParam("itemId") int itemId) {
		shopService.removeItemFromCart(ownerId, itemId);
		return "redirect:/owner/customer-outlet";
	}

	/* ************* Utilities ***************** */

	/**
	 * called by AopManager for initializing ownerid
	 * 
	 * @param ownerId
	 */
	public static void instantiateUser(String ownerId) {
		System.out.println("LOG: ownerId>> " + ownerId);
		ShopController.ownerId = ownerId;
	}

	/**
	 * handles merge of datas from ShopItem and OwnerCart and create a combined
	 * model
	 * 
	 * @param model
	 * @param shopItems
	 */
	private void manage_combinedModel(Model model, List<ShopItem> shopItems) {
		List<OwnerCartItem> cartItems = shopService.showCart(ownerId);
		List<CombinedDataModel> combinedModels = new ArrayList<>();
		for (ShopItem itemVar : shopItems) {
			CombinedDataModel combinedData = new CombinedDataModel();
			combinedData.setItemId(itemVar.getItemId());
			combinedData.setItemName(itemVar.getItemName());
			combinedData.setItemPrice(itemVar.getPrice());
			combinedData.setItemExpiryDate(itemVar.getExpDate());
			for (OwnerCartItem cartVar : cartItems) {
				if (itemVar.getItemId() == cartVar.getItemId()) {
					combinedData.setQuantity(cartVar.getQuantity());
				}
			}
			combinedModels.add(combinedData);
		}

		model.addAttribute("combinedModel", combinedModels);
	}

	/**
	 * returns owner
	 * 
	 * @return OwnerList
	 */
	private OwnerList getOwner() {
		OwnerList owner = userAuthService.findByOwnerName(ownerId);
		return owner;
	}

}
