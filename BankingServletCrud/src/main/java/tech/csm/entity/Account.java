package tech.csm.entity;

import java.io.Serializable;

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

@Entity
@Getter
@Setter
@ToString
@Table(name = "account_master")
public class Account implements Serializable {
	
	@Id
	@Column(name="account_no")
	private String accountNo;
	
	private String name;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="account_type")
	private String accountType;
	
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="bank_id")
	private Bank bank;
}
