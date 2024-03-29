package com.souravsahoo.SRSproj.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.souravsahoo.SRSproj.config.ApplicationAuthenticationFacade;
import com.souravsahoo.SRSproj.controller.ShopController;
import com.souravsahoo.SRSproj.controller.UserShoppingController;

@Component
@Aspect
public class AopManager {

	@Autowired
	private ApplicationAuthenticationFacade authenticationFacade;

	@Before("execution(public String ownerHomePage(..))")
	public void beforeViewListOfItemsInShopController() {
		System.out.println("LOG: ownerId>> " + authenticationFacade.getAuthentication().getName());
		ShopController.instantiateUser(authenticationFacade.getAuthentication().getName());
	}

	@Before("execution(public String com.souravsahoo.SRSproj.controller.UserShoppingController.home(..))")
	public void beforeViewListOfItemsInUserShoppingController() {
		System.out.println("LOG: ownerId>> " + authenticationFacade.getAuthentication().getName());
		UserShoppingController.instantiateUser(authenticationFacade.getAuthentication().getName());
	}
}
