package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tech.csm.domain.Student;
import tech.csm.util.DBUtil;

public class StudentDaoImpl implements StudentDao {
	private Connection con;
	public StudentDaoImpl() {
		con=DBUtil.getConnection();
		
	}
	
	
	@Override
	public String saveStudent(Student st) {
		final String seQuery="insert into student(roll_no,name,cgpa,address_id) values(?,?,?,?)";
		final String adQuery="insert into address(lane,city,state,zip) values(?,?,?,?)";
		int c=0;
		Integer addId=0;
		try {
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement(adQuery,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, st.getAddress().getLane());
			ps.setString(2, st.getAddress().getCity());
			ps.setString(3, st.getAddress().getState());
			ps.setString(4, st.getAddress().getZip());
			c=ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			rs.next();
			addId=rs.getInt(1);
			ps=con.prepareStatement(seQuery);
			ps.setString(1, st.getRollNo());
			ps.setString(2, st.getName());
			ps.setDouble(3, st.getCgpa());
			ps.setInt(4, addId);
			
			c=ps.executeUpdate();
			
			con.commit();
			rs.close();
			ps.close();
		} catch (SQLException e) {			
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return c+" student saved ";
	}

}
