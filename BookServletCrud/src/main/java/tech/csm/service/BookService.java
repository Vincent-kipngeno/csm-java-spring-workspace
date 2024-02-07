package tech.csm.service;

import java.util.List;

import tech.csm.entity.BookVO;

public interface BookService {

	String saveBook(BookVO bvo);

	List<BookVO> getAllBooks();

}
