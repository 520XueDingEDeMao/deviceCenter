package com.device.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DeviceUserDetailsService implements UserDetailsService{
	Logger log=LoggerFactory.getLogger(DeviceUserDetailsService.class);
	
	private static Map<String,UserDetails>userMap;//存放用户信息的map(暂时)

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("当前调用的userName={}",userName);
		if(StringUtils.isNotBlank(userName)) {
			UserDetails user=userMap.get(userName);
			if(null!=user) {
				return user;
			}
		}
		return null;
	}
	
	static {
		userMap=new HashMap<String,UserDetails>();
		userMap.put("user_1", User.withUsername("user_1").password("123456").roles("USER").build());
		userMap.put("user_2", User.withUsername("user_2").password("123456").roles("ADMIN").build());
		userMap.put("user_3", User.withUsername("user_3").password("123456").roles("DB").build());
	}

}
