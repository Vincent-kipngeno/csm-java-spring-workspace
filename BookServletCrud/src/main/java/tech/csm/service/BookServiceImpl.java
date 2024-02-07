package tech.csm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tech.csm.dao.BookDao;
import tech.csm.dao.BookDaoImpl;
import tech.csm.entity.Book;
import tech.csm.entity.BookVO;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	public BookServiceImpl() {
		bookDao=new BookDaoImpl();
	}
	
	@Override
	public String saveBook(BookVO bvo) {
		
		Book b=new Book();
		b.setTitle(bvo.getTitle());
		b.setPrice(Double.parseDouble(bvo.getPrice()));
		b.setAuthorName(bvo.getAuthorName());
		b.setPublicationName(bvo.getPublicationName());
		try {
			b.setPublicationDate(new SimpleDateFormat("yyyy-MM-dd").parse(bvo.getPublicationDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bookDao.saveBook(b);
		
	}

	@Override
	public List<BookVO> getAllBooks() {
		List<Book> bookList=bookDao.getAllBooks();
		List<BookVO> bookVoList=null;
		
		if(bookList!=null) {
			bookVoList=new ArrayList<>();
			for(Book x:bookList) {
				BookVO bvo=new BookVO();
				bvo.setBookId(x.getBookId().toString());
				bvo.setTitle(x.getTitle());
				bvo.setAuthorName(x.getAuthorName());
				bvo.setPrice(x.getPrice().toString());
				bvo.setPublicationName(x.getPublicationName());
				bvo.setPublicationDate(new SimpleDateFormat("yyyy-MM-dd").format(x.getPublicationDate()));
				bookVoList.add(bvo);
			}
		}
		return bookVoList;
	}

}
