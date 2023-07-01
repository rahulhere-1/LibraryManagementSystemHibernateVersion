package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.connection.DatabaseConnetion;
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
}
