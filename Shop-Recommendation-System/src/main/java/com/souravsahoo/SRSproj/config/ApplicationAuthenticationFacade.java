package com.souravsahoo.SRSproj.config;

import org.springframework.security.core.Authentication;

public interface ApplicationAuthenticationFacade {
	Authentication getAuthentication();
}
