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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "t_address_master") @Getter @Setter @ToString
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	
	private String lane;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roll_no")
	private Student student;	
}
