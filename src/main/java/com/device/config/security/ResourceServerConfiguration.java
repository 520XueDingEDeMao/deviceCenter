package com.device.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源控制服务器
 * @author ningque
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests()
    	 .antMatchers("/oauth/*","/hello","/preload","/stopping").permitAll()//以hello 开头的url 不需要验证
    	// .antMatchers("/admin").hasRole("ADMIN")//以 admin 开头的请求，需要admin权限的用户
    	 //.antMatchers("/db").hasAnyRole("DB")//以 db 开头的请求，需要db权限的用户
    	 //任何没有被匹配上的url 需要用户被验证
    	 .anyRequest().authenticated()
    	 .and().csrf().disable();
    	  
    }

}