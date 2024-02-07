package tech.csm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tech.csm.entity.Address;
import tech.csm.entity.Branch;
import tech.csm.entity.Course;
import tech.csm.entity.Student;



public class DBUtil {
	private static SessionFactory sessionFactory;
	static {	
		sessionFactory=new Configuration()
				.addAnnotatedClass(Branch.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
