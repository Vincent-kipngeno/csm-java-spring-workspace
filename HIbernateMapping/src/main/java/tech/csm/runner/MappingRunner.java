package tech.csm.runner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tech.csm.entity.Aadhar;
import tech.csm.entity.Person;
import tech.csm.util.DBUtil;

public class MappingRunner {

	public static void main(String[] args) {
		Session ses=DBUtil.getSessionFactory().openSession();
		
		
		Transaction tx=ses.beginTransaction();
		
		Aadhar a=ses.get(Aadhar.class, "76565434");
		System.out.println(a);
		System.out.println(a.getPerson());
		
		tx.commit();
		
		
		ses.close();
	}

}
//Aadhar a=new Aadhar();
//a.setAadharId("76565434");
//a.setPhoneNo("9876667656");
//a.setAddress("cuttack");
//Person p=new Person();
//p.setPersonName("Sumit Das");
//p.setAadhar(a);