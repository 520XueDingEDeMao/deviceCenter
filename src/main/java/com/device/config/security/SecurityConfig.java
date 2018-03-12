package com.device.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

import com.device.service.DeviceUserDetailsService;

/**
 * Security 控制
 * @author ningque
 *
 */
@Configuration
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private DeviceUserDetailsService useeService;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(useeService);
	}
}
