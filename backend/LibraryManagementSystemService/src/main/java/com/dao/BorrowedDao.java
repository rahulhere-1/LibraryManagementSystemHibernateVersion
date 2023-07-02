package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.connection.DatabaseConnetion;
import com.entities.Book;
import com.entities.Borrowed;


@Repository
public class BorrowedDao {
	
	public List<Borrowed> getAllBorrowers() {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Borrowed> q = ss.createQuery("from Borrowed", Borrowed.class);
		List<Borrowed> borrowed =q.list();
		ss.close();
		return borrowed;
	}
	
	public void addBorrower(Borrowed borrowed) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		ss.save(borrowed);
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void updateBorrower(Borrowed borrowed) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		ss.update(borrowed);
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void deleteBorrower(long id) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("delete from Borrowed where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void deleteBorrowerByIsbn(String isbn) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("delete from Borrowed where book_isbn=:isbn");
		q.setParameter("isbn", isbn);
		q.executeUpdate();
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void deleteBorrowerByMemberId(long id) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("delete from Borrowed where member_id=:id");
		q.setParameter("member_id", id);
		q.executeUpdate();
		ss.getTransaction().commit();
		ss.close();
	}

}
