package tech.csm.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFilController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = "D:/file_server/" + req.getParameter("fileName");
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-disposition", "attachment;filename=" + req.getParameter("fileName"));
		
		try (FileInputStream in = new FileInputStream(fileName);
				OutputStream out = resp.getOutputStream()) {
			
	            byte[] buffer = new byte[1024];	            
	            int numBytesRead;
	            while ((numBytesRead = in.read(buffer)) > 0) {
	                out.write(buffer, 0, numBytesRead);
	            }
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
