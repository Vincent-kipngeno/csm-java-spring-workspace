package tech.csm.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Departments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -963390127624819980L;

	private Integer departmentId;
	
	private String departmentName;
	
}
