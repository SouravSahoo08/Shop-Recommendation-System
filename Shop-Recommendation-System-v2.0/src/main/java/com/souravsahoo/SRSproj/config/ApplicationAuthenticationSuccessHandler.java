package com.souravsahoo.SRSproj.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class ApplicationAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public ApplicationAuthenticationSuccessHandler() {
		super();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {

			// Shop owner
			if (authority.getAuthority().equals("ROLE_OWNER")) {
				try {

					redirectStrategy.sendRedirect(request, response, "/owner/home");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Customer
			else if (authority.getAuthority().equals("ROLE_CUSTOMER")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/user/home");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Admin
			else if (authority.getAuthority().equals("ROLE_ADMIN")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/admin");
				} catch (Exception e) {
					System.out.println("here");
					e.printStackTrace();
				}
			} else {
				throw new IllegalStateException();
			}
		});

	}

}
