package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagementSystemController {
	
	
	@RequestMapping("/home")
	public String getHomePage() {
		return "home page is here";
	}

}
