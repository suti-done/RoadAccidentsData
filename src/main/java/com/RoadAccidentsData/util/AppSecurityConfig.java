package com.RoadAccidentsData.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.RoadAccidentsData.dao.JpaUserDetailsService;
import com.RoadAccidentsData.entity.user;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	 private AuthenticationProviderService authenticationProvider;
	
	 private final PasswordEncoder passwordEncoder;
	 
	 @Autowired
	 public AppSecurityConfig(PasswordEncoder passwordEncoder)
	 {
		 this.passwordEncoder=passwordEncoder;
	 }
	 
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
    {
		//jdbc authentication
    	//auth.jdbcAuthentication().dataSource(securityDataSource);
    	 //auth.userDetailsService(userService);
    
    	auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		 
		http.authorizeRequests()
		.antMatchers("/api/accidents/**").authenticated()
		.antMatchers("/api/addUser").access("permitAll")
		.and()
		.httpBasic();
		
		//super.configure(http);
	    http.csrf().disable();
		//.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
	

}
