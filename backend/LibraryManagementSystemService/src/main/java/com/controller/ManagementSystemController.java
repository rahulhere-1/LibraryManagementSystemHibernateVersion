package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Student;
import com.services.ManagementSystemService;

@RestController
public class ManagementSystemController {
	
	@Autowired
	private ManagementSystemService service;
	
	@RequestMapping("/home")
	public String getHomePage() {
		return "home page is here";
	}
	
	/*@RequestMapping("/add")
	public void addThisGuy(){

		Student st = new Student(231,"new student","hyd");
		service.addStudent(st);
	}*/

}
