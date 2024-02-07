package tech.csm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tech.csm.entity.BookVO;
import tech.csm.service.BookService;
import tech.csm.service.BookServiceImpl;
import tech.csm.util.DBUtil;

public class BookController extends HttpServlet {
	
	private BookService bookService;
	public BookController() {
		bookService=new BookServiceImpl();
	}
	
	@Override
	public void init() throws ServletException {
		DBUtil.getSessionFactory();
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();		
		BookVO bvo=new BookVO();
		bvo.setTitle(req.getParameter("bid"));
		bvo.setPrice(req.getParameter("bpriceid"));
		bvo.setPublicationName(req.getParameter("pnid"));
		bvo.setPublicationDate(req.getParameter("pdateid"));
		bvo.setAuthorName(req.getParameter("anid"));
		String msg=bookService.saveBook(bvo);
		
		List<BookVO> bookList=bookService.getAllBooks();
		
//		pw.println("<h2>"+msg+"</h2>");
//		pw.println("<a href='http://localhost:9080/BookServletCrud'>Home</a>");
		
//		bookList.forEach(x->pw.println(x));
		
	pw.println("<html><head></head><body>");
	pw.println("<table border='1'><tr><th>Book Id</th><th>Title</th><th>Price</th></tr>");
	for(BookVO b:bookList) {
		pw.println("<tr><td>"+b.getBookId()+"</td><td>"+b.getTitle()+"</td><td>"+b.getPrice()+"</td></tr>");
	}
	pw.println("</table></body></html>");	
		
	}
}
