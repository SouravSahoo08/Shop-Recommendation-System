package com.souravsahoo.SRSproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
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
import com.souravsahoo.SRSproj.service.UserAuthService;

@Controller
@RequestMapping /* ("/") */
public class SystemHomepageController {
	
	
	@Autowired
	private UserAuthService userAuthService;

	@Autowired
	private UserDetailsManager userDetailsManager;
/*
	@Autowired
	private PasswordEncoder passwordEncoder;
*/	 
	@RequestMapping("/home")
	public String homePage() {
		return "home-page";
	}
	 
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "loginpage";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}


	@RequestMapping("/homelogin")
	public String homeLogin() {
		return "home";
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

		String ownerUsername = crmOwner.getsUsername();
		//String encodedPassword = passwordEncoder.encode(crmOwner.getsPwd());
		String ownerPwd = "{noop}"+crmOwner.getsPwd();

		OwnerList existingOwner = userAuthService.findByOwnerName(ownerUsername);
		if (existingOwner != null) {
			model.addAttribute("shop-registration-details", new CrmOwner());
			model.addAttribute("registrationError", "Owner already exists");
			return "shop-register";
		}

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
		authorities.add(new SimpleGrantedAuthority("ROLE_OWNER"));
		User ownerUser = new User(ownerUsername, ownerPwd, authorities);

		userDetailsManager.createUser(ownerUser);
		userAuthService.saveOwner(crmOwner);
		return "redirect:/showMyLoginPage";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer-registration-details") CrmCustomer crmCustomer, Model model) {

		String customerUsername = crmCustomer.getcUsername();
		//String encodedPassword = passwordEncoder.encode(crmCustomer.getcPwd());
		String customerPwd = "{noop}" + crmCustomer.getcPwd();

		CustomerList existingCustomer = userAuthService.findByCustomerName(customerUsername);
		if (existingCustomer != null) {
			model.addAttribute("customer-registration-details", new CrmCustomer());
			model.addAttribute("registrationError", "customer already exists");
			return "user-register";
		}

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
		authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
		User customerUser = new User(customerUsername, customerPwd, authorities);

		userDetailsManager.createUser(customerUser);
		userAuthService.saveCustomer(crmCustomer);
		return "redirect:/showMyLoginPage";
	}

	@PostMapping("/saveAdmin")
	public String saveAdmin(@ModelAttribute("customer-registration-details") CrmAdmin crmAdmin, Model model) {

		String adminUsername = crmAdmin.getaUsername();
		//String encodedPassword = passwordEncoder.encode(crmAdmin.getaPwd());
		String adminPwd = "{noop}" + crmAdmin.getaPwd();

		AdminList existingAdmin = userAuthService.findByAdminName(adminUsername);
		if (existingAdmin != null) {
			model.addAttribute("customer-registration-details", new CrmAdmin());
			model.addAttribute("registrationError", "Admin already exists");
			return "admin-register";
		}

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		User adminUser = new User(adminUsername, adminPwd, authorities);

		userDetailsManager.createUser(adminUser);
		userAuthService.saveAdmin(crmAdmin);
		return "redirect:/showMyLoginPage";
	}
	
	
}