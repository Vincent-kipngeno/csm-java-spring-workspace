package tech.csm.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_address_master")
@Getter @Setter
public class Address implements Serializable {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private String lane;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
	
	private String zip;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roll_no")
	private Student student;
}
