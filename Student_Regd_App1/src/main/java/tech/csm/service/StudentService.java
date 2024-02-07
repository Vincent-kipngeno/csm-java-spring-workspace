package tech.csm.service;

import java.util.List;

import tech.csm.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

}
