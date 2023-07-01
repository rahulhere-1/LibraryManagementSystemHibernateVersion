package com.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnetion {
	
	private static SessionFactory sf;
	
	
	public static SessionFactory getFactory() {
		if(sf==null)
		{
			try {
				sf=new Configuration().configure().buildSessionFactory();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return sf;
	}

}
