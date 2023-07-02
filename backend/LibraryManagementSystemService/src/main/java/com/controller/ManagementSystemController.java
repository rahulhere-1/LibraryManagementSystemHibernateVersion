package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/*  Books REST APIs -------------------------------------------------  */
	
	@GetMapping("/library")
	public List<Book> retrieveAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping("/library")
	public void addBook(@RequestBody Book book ){
		service.addBook(book);
	}
	
	@PutMapping("/library")
	public void updateBook(@RequestBody Book book ){
		service.updateBook(book);
	}
	
	@DeleteMapping("/library/{isbn}")
	public void deleteBook(@PathVariable String isbn) {
		service.deleteBook(isbn);
	}
	

	@GetMapping("/library/{isbn}")
	public Book getBookById(@PathVariable String isbn){
		return service.findBookById(isbn);
	}

	/*  Member REST APIs   ----------------------------------------------  */
	
	@GetMapping("/members")
	public List<Member> retrieveAllMembers(){
		return service.getAllMembers();
	}
	
	@PostMapping("/members")
	public void addMember(@RequestBody Member member){
		service.addMember(member);
	}
	
	@PutMapping("/members")
	public void updateMember(@RequestBody Member member){
		service.updateMember(member);
	}
	
	@DeleteMapping("/members/{id}")
	public void deleteMember(@PathVariable long id) {
		service.deleteMember(id);
	}
	

	@GetMapping("/members/{memberId}")
	public Member getMemberById(@PathVariable long memberId){
		return service.getMemberById(memberId);
	}

	/*  Borrowed REST APIs  -------------------------------------------  */
	
	@GetMapping("/borrowed")
	public List<Borrowed> retrieveAllBorrowers(){
		return service.getAllBorrowers();
	}
	
	

}
