package com.souravsahoo.SRSproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.souravsahoo.SRSproj.Crm_package.CrmAdmin;
import com.souravsahoo.SRSproj.Crm_package.CrmCustomer;
import com.souravsahoo.SRSproj.Crm_package.CrmOwner;
import com.souravsahoo.SRSproj.entity.AdminList;
import com.souravsahoo.SRSproj.entity.CustomerList;
import com.souravsahoo.SRSproj.entity.OwnerList;
import com.souravsahoo.SRSproj.service.OwnerUserInfo_Service;
import com.souravsahoo.SRSproj.service.UserAuthService;

@Controller
@RequestMapping /* ("/") */
public class SystemHomepageController {

	@Autowired
	private OwnerUserInfo_Service ownerUserInfo;
	
	@Autowired
	private UserAuthService userAuthService;

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "loginpage";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
	@RequestMapping("/home-page")
	public String homePage() {
		return "home-page";
	}

	@RequestMapping("/shop-register")
	public String registerOwner(Model model) {
		model.addAttribute("shop-registration-details", new CrmOwner());
		return "shop-register";
	}

	@RequestMapping("/customer-register")
	public String registerUser(Model model) {
		model.addAttribute("customer-registration-details", new CrmCustomer());
		return "user-register";
	}

	@RequestMapping("/admin-register")
	public String registerAdmin(Model model) {
		model.addAttribute("customer-registration-details", new CrmAdmin());
		return "admin-register";
	}
	
	@PostMapping("/saveOwner")
	public String saveOwner(@ModelAttribute("shop-registration-details") CrmOwner crmOwner, Model model) {
		
		OwnerList existingOwner = userAuthService.findByOwnerName(crmOwner.getOwnerName());
		if(existingOwner != null) {
			model.addAttribute("shop-registration-details", new CrmOwner());
			model.addAttribute("registrationError", "Owner already exists");
			return "shop-register";
		}
		
		
		userAuthService.saveOwner(crmOwner);
		return "redirect:/showMyLoginPage";
	}

	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer-registration-details") CrmCustomer crmCustomer, Model model) {
		
		CustomerList existingCustomer = userAuthService.findByCustomerName(crmCustomer.getCutomerName());
		if(existingCustomer!=null) {
			model.addAttribute("customer-registration-details", new CrmCustomer());
			model.addAttribute("registrationError", "customer already exists");
			return "user-register";
		}
		
		userAuthService.saveCustomer(crmCustomer);
		return "redirect:/showMyLoginPage";
	}

	@PostMapping("/saveAdmin")
	public String saveCustomer(@ModelAttribute("customer-registration-details") CrmAdmin crmAdmin, Model model) {
		
		AdminList existingAdmin = userAuthService.findByAdminName(crmAdmin.getAdminName());
		if(existingAdmin!=null) {
			model.addAttribute("customer-registration-details", new CrmAdmin());
			model.addAttribute("registrationError", "Admin already exists");
			return "admin-register";
		}
		
		userAuthService.saveAdmin(crmAdmin);
		return "redirect:/showMyLoginPage";
	}
}
