package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Book;

public interface BookDao {

	String saveBook(Book b);

	List<Book> getAllBooks();

}
