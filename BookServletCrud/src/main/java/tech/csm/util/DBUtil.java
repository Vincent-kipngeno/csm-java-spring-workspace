package tech.csm.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tech.csm.entity.Book;



public class DBUtil {
	private static SessionFactory sessionFactory;
	static {	
		sessionFactory=new Configuration()
				.addAnnotatedClass(Book.class)				
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
