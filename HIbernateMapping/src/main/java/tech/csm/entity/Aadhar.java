package tech.csm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="t_aadhar") @Getter @Setter @ToString(exclude = "person")
public class Aadhar implements Serializable {
	@Id
	@Column(name="aadhar_id")
	private String aadharId;
	@Column(name="phone_no")
	private String phoneNo;
	private String address;
	
	@OneToOne(mappedBy ="aadhar")	
	private Person person;
	
}
