package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.connection.DatabaseConnetion;
import com.entities.Book;
import com.entities.Member;

@Repository
public class MemberDao {
	
	
	public List<Member> getAllMembers() {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Member> q = ss.createQuery("from Member", Member.class);
		List<Member> members =q.list();
		ss.close();
		return members;
	}
	
	public Member getMemberById(long id) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Member> q = ss.createQuery("from Member where id=:id", Member.class);
		q.setParameter("id", id);
		Member member = q.uniqueResult();
		ss.close();
		return member;
	}
	
	public void addMember(Member member) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		ss.save(member);
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void deleteMember(long id) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		Query<Book> q = ss.createQuery("delete from Member where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		ss.getTransaction().commit();
		ss.close();
	}
	
	public void updateMember(Member member) {
		Session ss = DatabaseConnetion.getFactory().openSession();
		ss.beginTransaction();
		ss.update(member);
		ss.getTransaction().commit();
		ss.close();
	}
}
