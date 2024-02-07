package tech.csm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountVO {
	
	private String accountNo;
	
	private String name;
	
	private String phoneNo;
	
	private String emailId;
	
	private String accountType;
	
	private String balance;
	
	private BankVO bankVO;
}
