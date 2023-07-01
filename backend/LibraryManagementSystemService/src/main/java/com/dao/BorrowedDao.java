package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.connection.DatabaseConnetion;
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

}
