package com.device.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "auth2 hello";
	}
	@RequestMapping("/admin")
	public String adminTest() {
		return "auth2 admin";
	}
	@RequestMapping("/db")
	public String dbTest() {
		return "auth2 db";
	}
	@RequestMapping(value= {"/test"},method=RequestMethod.POST)
	public String userTest() {
		return "auth2 test";
	}
//	@RequestMapping("/login")
//	public String login() {
//		return "请登录....";
//	}

}
