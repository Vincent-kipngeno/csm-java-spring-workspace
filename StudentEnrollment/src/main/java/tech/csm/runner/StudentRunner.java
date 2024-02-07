package tech.csm.runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tech.csm.entity.Address;
import tech.csm.entity.Branch;
import tech.csm.entity.Course;
import tech.csm.entity.Student;
import tech.csm.util.DBUtil;

public class StudentRunner {

	public static void main(String[] args) throws ParseException {
		Session ses=DBUtil.getSessionFactory().openSession();
		
		
		Student s=new Student();
		s.setName("Amit Sahoo");
		s.setEmail("amit@gmail.com");
		s.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("12-01-2001"));
		s.setYroa(2022);
		s.setCgpa(7.2);
		s.setBranch(ses.get(Branch.class, 2));
		
		List<Address> addressList=new ArrayList<>();
		Address a=new Address();
		a.setLane("laxmi sagar");
		a.setCity("bbsr");
		a.setState("odisha");
		a.setZip("765654");
		a.setStudent(s);
		addressList.add(a);
		a=new Address();
		a.setLane("Old Town");
		a.setCity("bbsr");
		a.setState("odisha");
		a.setZip("7655654");
		a.setStudent(s);
		addressList.add(a);
		
		s.setAddress(addressList);
		
		
		List<Course> courseList=new ArrayList<>();
		courseList.add(ses.get(Course.class,1));
		courseList.add(ses.get(Course.class,2));
		
		s.setCourses(courseList);
		Transaction tx = ses.beginTransaction();
		ses.persist(s);
		tx.commit();
		ses.close();

	}

}
