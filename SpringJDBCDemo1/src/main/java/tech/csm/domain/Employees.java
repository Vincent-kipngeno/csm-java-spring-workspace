package tech.csm.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Employees implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 908066151368352623L;
	private Integer employeeId;
	private String lastName;
	private Double salary;
	private String jobId;
	private Date hireDate;
	
	
	
}
