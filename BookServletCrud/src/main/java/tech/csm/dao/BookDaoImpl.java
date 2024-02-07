package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tech.csm.entity.Book;
import tech.csm.util.DBUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public String saveBook(Book b) {
		String msg="";
		Session ses=DBUtil.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ses.persist(b);	
		msg+="1 book saved with id "+ses.getIdentifier(b);
		tx.commit();
		ses.close();
		return msg;
	}

	@Override
	public List<Book> getAllBooks() {
		final String seQuery="from Book";
		List<Book> bookList=null;
		Session ses=DBUtil.getSessionFactory().openSession();
		Query<Book> q=ses.createQuery(seQuery);		
		bookList=q.list();
		ses.close();
		return bookList;
	}

}
