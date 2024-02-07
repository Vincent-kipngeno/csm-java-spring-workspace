package org.example.MavenJdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productjdbc", "root", "Taptet#2001");
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery("select product_id, mfg_date, product_name, unit_price from products")) {
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
