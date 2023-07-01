package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.connection.DatabaseConnetion;
import com.entities.Book;
import com.entities.Borrowed;
import com.entities.Member;

@Repository
public class BookDao {
	
	public List<Book> getAllBooks() {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("from Book", Book.class);
		List<Book> books =q.list();
		ss.close();
		return books;
	}
	

}
