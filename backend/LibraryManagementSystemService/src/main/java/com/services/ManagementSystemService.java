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
	private MemberDao memberDao;
	
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
	/*  Member Table Methods -----------------------------------------*/

	public List<Member> getAllMembers(){
		return memberDao.getAllMembers();
	}
	
	public void addMember(Member member) {
		memberDao.addMember(member);
	}
	
	public void deleteMember(long id) {
		memberDao.deleteMember(id);
	}
	
	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}
	
	public Member getMemberById(long id){
		return memberDao.getMemberById(id);
	}
	/*  Borrowed Table Methods -----------------------------------------*/
	
	public List<Borrowed> getAllBorrowers(){
		return borrowedDao.getAllBorrowers();
	}
	
	public void addBorrower(Borrowed borrowed) {
		borrowedDao.addBorrower(borrowed);
	}
	
	public void updateBorrower(Borrowed borrowed) {
		borrowedDao.updateBorrower(borrowed);
	}
	public void deleteBorrower(long id) {
		borrowedDao.deleteBorrower(id);
	}
	
	public void deleteBorrowerByIsbn(String isbn) {
		borrowedDao.deleteBorrowerByIsbn(isbn);
	}
	
	public void deleteBorrowerByMemberId(long id) {
		borrowedDao.deleteBorrowerByMemberId(id);
	}
	
}
