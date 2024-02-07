package tech.csm.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tech.csm.entity.Bank;
import tech.csm.entity.Account;
import tech.csm.entity.BTransaction;





public class DBUtil {
	private static SessionFactory sessionFactory;
	static {	
		sessionFactory=new Configuration()
				.addAnnotatedClass(Bank.class)	
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(BTransaction.class)
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
