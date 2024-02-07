package tech.csm.service;

import tech.csm.dao.StudentDao;
import tech.csm.dao.StudentDaoImpl;
import tech.csm.domain.StudentVO;
import tech.csm.domain.Address;
import tech.csm.domain.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao=null;
	public StudentServiceImpl() {
		studentDao=new StudentDaoImpl();
	}
	@Override
	public String saveStudent(StudentVO svo) {
		
		Student st=new Student();
		Address ad=new Address();
		st.setRollNo(svo.getRollNo());
		st.setName(svo.getName());
		st.setCgpa(Double.parseDouble(svo.getCgpa()));
		ad.setLane(svo.getAddress().getLane());
		ad.setCity(svo.getAddress().getCity());
		ad.setState(svo.getAddress().getState());
		ad.setZip(svo.getAddress().getZip());
		st.setAddress(ad);
		return studentDao.saveStudent(st);
	}
	
	

}
