package tech.csm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "t_student_master") @Getter @Setter @ToString
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_no")
	private Integer rollNo;
	
	private String name;
	
	private String email;
	
	private Date dob;
	
	private Double cgpa;
	
	private Integer yroa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_student_course",
			joinColumns = @JoinColumn(name="roll_no"),
			inverseJoinColumns = @JoinColumn(name="course_id"))			
	private List<Course> courses;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)	
	private List<Address> address;
	
}
