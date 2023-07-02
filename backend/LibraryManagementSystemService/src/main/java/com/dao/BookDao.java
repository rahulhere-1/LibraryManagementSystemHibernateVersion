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
	
	
	public Book findBookById(String isbn) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("from Book where isbn=:isbn", Book.class);
		q.setParameter("isbn", isbn);
		Book book =q.uniqueResult();
		ss.close();
		return book;
	}
	
	public void addBook(Book book) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		ss.save(book);
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void deleteBook(String isbn) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("delete from Book where isbn=:isbn");
		q.setParameter("isbn", isbn);
		q.executeUpdate();
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void updateBook(Book book) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		ss.update(book);
		ss.getTransaction().commit();
		ss.close();
	}
	

}
