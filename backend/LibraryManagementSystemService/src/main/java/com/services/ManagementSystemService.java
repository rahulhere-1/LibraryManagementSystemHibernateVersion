package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BookDao;
import com.dao.BorrowedDao;
import com.dao.MemberDao;
import com.entities.Book;
import com.entities.Borrowed;
import com.entities.Member;

@Service
public class ManagementSystemService {
		
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private MemberDao memberDoa;
	
	@Autowired
	private BorrowedDao borrowedDao;
	
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	
	public Book findBookById(String isbn) {
		return bookDao.findBookById(isbn);
	}
	
	public void addBook(Book book) {
		 bookDao.addBook(book);
	}
	
	public void deleteBook(String isbn) {
		 bookDao.deleteBook(isbn);
	}
	
	public void updateBook(Book book) {
		 bookDao.updateBook(book);
	}
	
	public List<Member> getAllMembers(){
		return memberDoa.getAllMembers();
	}
	
	public Member getMemberById(long id){
		return memberDoa.getMemberById(id);
	}
	
	public List<Borrowed> getAllBorrowers(){
		return borrowedDao.getAllBorrowers();
	}
	
}
