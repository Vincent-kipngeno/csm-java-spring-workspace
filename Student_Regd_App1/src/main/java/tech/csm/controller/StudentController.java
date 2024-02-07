package tech.csm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;
import tech.csm.model.Branch;
import tech.csm.model.City;
import tech.csm.model.Course;
import tech.csm.model.State;
import tech.csm.model.Student;
import tech.csm.repo.CityRepo;
import tech.csm.repo.CourseRepo;
import tech.csm.repo.StateRepo;
import tech.csm.repo.StudentRepo;
import tech.csm.service.BranchService;
import tech.csm.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private BranchService branchService;
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepo studentRepo;
	
	
	@RequestMapping(path="/getform", method = RequestMethod.GET)
	public String getStudentRegdForm(Model model) {
		
		Integer crrYear=Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		List<Integer> yearList=new ArrayList<>();
		for(int i=crrYear;i>crrYear-4;i--)
			yearList.add(i);
		
		List<Branch> branchList=branchService.getAllBranches();
		List<Course> courseList=courseRepo.findAll();
		List<State> stateList=stateRepo.findAll();
		List<Student> studentList=studentService.getAllStudents();
		
		model.addAttribute("courseList",courseList);
		model.addAttribute("branchList", branchList);
		model.addAttribute("yearList", yearList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("studentList", studentList);
		return "registration";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent( @ModelAttribute Student student, RedirectAttributes rd ) {
		System.out.println(student);
		Student st=studentService.saveStudent(student);
		rd.addFlashAttribute("msg","Student enrolled with roll no:"+st.getRollNo());
		return "redirect:./getform";
	}
	
	@GetMapping("/getCityByStateId")
	public void getCityByStateId(@RequestParam("stateId") Integer sId, HttpServletResponse resp) throws IOException {
		
		List<City> cityList=cityRepo.getCityByStateId(sId);
		
		String op="<option value='0'>-Select-</option>";
		for(City c:cityList) 
			op+="<option value='"+c.getCityId()+"'>"+c.getCityName()+"</option>";
		resp.getWriter().print(op);
	}
	
	@GetMapping("/getFeesByCourseId")
	public void getFeesByCourseId(@RequestParam("courseId") Integer cId, HttpServletResponse resp) throws IOException {
		Course c=courseRepo.findById(cId).get();
		resp.getWriter().print(c.getFees());
	}
	
	@GetMapping("/test")
	public void test() {		
	//	List<Student> studentList=studentRepo.findByYearOfAddmissionOrderByCgpa(2024);
		List<Student> studentList=studentRepo.getAllByCgpaIn(7.2,6.9);
		System.out.println(studentList);
	}
	
	
}
