package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Book;
import com.entities.Borrowed;
import com.entities.Member;
import com.services.ManagementSystemService;

@RestController
public class ManagementSystemController {
	
	@Autowired
	private ManagementSystemService service;
	
	@RequestMapping("/home")
	public String getHomePage() {
		return "home page is here";
	}
	

	@RequestMapping("/")
	public String welcomePage() {
		return "try /library";
	}
	
	@GetMapping("/library")
	public List<Book> retrieveAllBooks(){
		return service.getAllBooks();
	}
	
	@GetMapping("/members")
	public List<Member> retrieveAllMembers(){
		return service.getAllMembers();
	}
	
	@GetMapping("/borrowed")
	public List<Borrowed> retrieveAllBorrowers(){
		return service.getAllBorrowers();
	}
	
	

}
