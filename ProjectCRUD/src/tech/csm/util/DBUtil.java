package tech.csm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection con;
	
	public static Connection getConnection() {
		if(con==null) {			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Taptet#2001");
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			return con;
		}
		else
			return con;
	}
	
	public static void closeConnection() {
		if(con!=null) {
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
