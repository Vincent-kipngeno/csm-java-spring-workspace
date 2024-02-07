package tech.csm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tech.csm.entity.Aadhar;
import tech.csm.entity.Person;



public class DBUtil {
	private static SessionFactory sessionFactory;
	static {	
		sessionFactory=new Configuration()
				.addAnnotatedClass(Aadhar.class)
				.addAnnotatedClass(Person.class)
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
