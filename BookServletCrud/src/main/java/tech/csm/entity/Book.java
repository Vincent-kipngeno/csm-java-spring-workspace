package tech.csm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4434936926849899494L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookId;
	
	private String title;
	
	private Double price;
	@Column(name = "author_name")
	private String authorName;
	@Column(name = "publication_name")
	private String publicationName;
	@Column(name = "publication_date")
	private Date publicationDate;
}
