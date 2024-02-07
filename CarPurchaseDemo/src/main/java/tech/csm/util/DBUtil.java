package tech.csm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tech.csm.entity.Category;
import tech.csm.entity.Product;
import tech.csm.entity.Purchase;



public class DBUtil {
	private static SessionFactory sessionFactory;
	static {	
		sessionFactory=new Configuration()
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Purchase.class)
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
