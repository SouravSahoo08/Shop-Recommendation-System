package com.souravsahoo.SRSproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/**
 * Here we will specify the type of authentication to be done for the application
 * @author jacky
 *
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig{
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
		return new ApplicationAuthenticationSuccessHandler();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
		return http
		.authorizeRequests(configurer->
			configurer.antMatchers("/home-page").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
						.antMatchers("/owner/**").hasRole("MANAGER")
						.antMatchers("/user-2/**").hasRole("EMPLOYEE"))
		.formLogin(configurer ->
			configurer.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.successHandler(myAuthenticationSuccessHandler())
					.permitAll())
		.logout(configurer -> 
			configurer.permitAll())
		.exceptionHandling(configurer->
			configurer.accessDeniedPage("/access-denied"))
		.build();
    }
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails john = User.builder()
	            .username("john")
	            .password("{noop}test123")
	            .roles("EMPLOYEE")
	            .build();

	        UserDetails mary = User.builder()
	                .username("mary")
	                .password("{noop}test123")
	                .roles("MANAGER")
	                .build();

	        UserDetails susan = User.builder()
	                .username("susan")
	                .password("{noop}test123")
	                .roles("ADMIN")
	                .build();
	        
	        return new InMemoryUserDetailsManager(john,mary,susan);
	}
	
}
