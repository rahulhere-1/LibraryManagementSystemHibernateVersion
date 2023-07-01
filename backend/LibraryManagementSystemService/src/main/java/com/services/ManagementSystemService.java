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
	
	public List<Member> getAllMembers(){
		return memberDoa.getAllMembers();
	}
	
	public List<Borrowed> getAllBorrowers(){
		return borrowedDao.getAllBorrowers();
	}
	
}
