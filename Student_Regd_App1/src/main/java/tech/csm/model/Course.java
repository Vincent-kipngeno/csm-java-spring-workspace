package tech.csm.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_course_master")
@Getter @Setter 
public class Course implements Serializable {


	@Id
	@Column(name = "course_id")
	private Integer courseId;
	@Column(name = "course_title")
	private String courseName;
	private Double fees;
}
