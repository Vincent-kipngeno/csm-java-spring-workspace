package tech.csm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_student_master")
@Getter @Setter @ToString
public class Student implements Serializable {

	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollNo;
	
	@NotBlank(message = "Name cant't be empty!!")
	private String name;

	@Email(message = "Email not valid!!")
	private String email;
	
	@PastOrPresent(message = "doa cant be a future date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	
	@Min(value = 0, message="not less than 0")
	@Max(value = 10, message="less thatn 10")
	private Double cgpa;
	
	@Column(name = "yroa")
	private Integer yearOfAddmission;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	
	@ManyToMany
	@JoinTable(name = "t_student_course", joinColumns = @JoinColumn(name="roll_no"), inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> courses;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Address> addresses;
	
}
