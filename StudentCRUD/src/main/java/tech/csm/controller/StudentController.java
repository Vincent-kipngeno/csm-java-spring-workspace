package tech.csm.controller;

import java.util.Scanner;

import tech.csm.domain.AddressVO;
import tech.csm.domain.StudentVO;
import tech.csm.service.StudentService;
import tech.csm.service.StudentServiceImpl;

public class StudentController {

	private static StudentService studentService = new StudentServiceImpl();
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Scanner ss=new Scanner(System.in);
		
		System.out.println("Enter troll_no,name,cgpa");
		StudentVO svo=new StudentVO();
		svo.setRollNo(ss.nextLine());
		svo.setName(ss.nextLine());
		svo.setCgpa(ss.nextLine());
		System.out.println("Enter lane,city,state,zip");
		AddressVO avo=new AddressVO();
		avo.setLane(ss.nextLine());
		avo.setCity(ss.nextLine());
		avo.setState(ss.nextLine());
		avo.setZip(ss.nextLine());		
		svo.setAddress(avo);
		
		String msg=studentService.saveStudent(svo);
		System.out.println(msg);

	}

}
