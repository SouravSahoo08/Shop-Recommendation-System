package com.souravsahoo.SRSproj.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/**
 * Here we will specify the type of authentication to be done for the application
 * @author jacky
 *
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.souravsahoo.SRSproj")
public class ApplicationSecurityConfig{
	
	@Autowired
	private DataSource securityDataSource;
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(securityDataSource);
	}
		
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
	
}
