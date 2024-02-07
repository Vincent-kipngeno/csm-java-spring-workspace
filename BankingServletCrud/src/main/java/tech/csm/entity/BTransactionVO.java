package tech.csm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BTransactionVO {
	
	private String transactionId;
	
	private String transactionDate;
	
	private String transactionType;
	
	private String amount;
	
	private AccountVO accountVO;
}
