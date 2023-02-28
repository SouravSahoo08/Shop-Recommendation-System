package com.souravsahoo.SRSproj.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements ApplicationAuthenticationFacade {

	@Override
	public Authentication getAuthentication() {
		// TODO Auto-generated method stub
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
