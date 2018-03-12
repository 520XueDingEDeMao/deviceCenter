package com.device.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义用户信心
 * @author ningque
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//		 InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//	        //创建两个用户
//	        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
//	        manager.createUser(User.withUsername("user_2").password("123456").roles("ADMIN").build());
		System.out.println("loadUserByUsername:"+arg0);
		return User.withUsername("user_2").password("123456").roles("USER").build();
	}

}
