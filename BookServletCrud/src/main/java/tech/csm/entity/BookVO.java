package tech.csm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BookVO {
	
	private String bookId;
	
	private String title;
	
	private String price;
	
	private String authorName;
	
	private String publicationName;
	
	private String publicationDate;
	
}
