package tech.csm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.csm.util.DBUtil;


@MultipartConfig(fileSizeThreshold = 1024*1024*5, maxFileSize = 1024*1024*10)
public class MainController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		DBUtil.getSessionFactory();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String endPoint=req.getServletPath();
		if(endPoint.equals("/getRegdForm")) {
			RequestDispatcher rd = req.getRequestDispatcher("/getRegdForm");
			rd.forward(req, resp);
		}else if(endPoint.equals("/getPachayatByBlockId")) {
			RequestDispatcher rd = req.getRequestDispatcher("/getPachayatByBlockId");
			rd.forward(req, resp);			
		}else if(endPoint.equals("/saveVlg")) {
			RequestDispatcher rd = req.getRequestDispatcher("/saveVlg");
			rd.forward(req, resp);		
		}else if(endPoint.equals("/downloadFile")) {
			RequestDispatcher rd = req.getRequestDispatcher("/downloadFile");
			rd.forward(req, resp);	
		}
	}
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
