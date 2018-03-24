package com.device.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreController {
	
	public static boolean running=true;
	
	@RequestMapping("/preload")
	public String preload() {
		if(running) {
			return "看什么看，我跑的好好的!!";
		}else {
			return "不用看了，已经挂了!!";
		}
	}
	@RequestMapping("/stopping")
	public void stopning() {
		running=false;
	}
	

}
