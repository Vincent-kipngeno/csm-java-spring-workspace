package tech.csm.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tech.csm.domain.Departments;
import tech.csm.domain.Employees;

@Controller
public class TestController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/getdata")
	public String getData() throws DataAccessException, ParseException {

		List<Employees> empList=jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(
						"select employee_id,last_name,salary,job_id,hire_date from employees where job_id=? and salary > ?");
				ps.setString(1, "IT_PROG");
				ps.setDouble(2, 5000);
				return ps;
			}
		}, new RowMapper<Employees>() {

			@Override
			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employees e = new Employees();				
				e.setEmployeeId(rs.getInt(1));
				e.setLastName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setJobId(rs.getString(4));
				e.setHireDate(rs.getDate(5));
				return e;
			}
		});
		
		empList.forEach(x->System.out.println(x));
		
		

//		List<Map<Integer, Integer>> datas=jdbcTemplate.query("select department_id, count(*) as no_of_emps from employees where department_id is not null group by department_id ",
//				new RowMapper<Map<Integer, Integer>>(){
//
//					@Override
//					public Map<Integer, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Map<Integer, Integer> data=new HashMap<>();
//						data.put(rs.getInt(1), rs.getInt(2));
//						return data;
//					}
//			
//		});
//		
//		for(Map<Integer, Integer> x:datas) {
//			for(Entry<Integer, Integer> e: x.entrySet()) {
//				System.out.println(e.getKey()+"  -  "+e.getValue());
//			}
//		}
//			

//		List<Employees> empList=jdbcTemplate.query("select employee_id,last_name,salary,job_id,hire_date from employees where hire_date between ? and ? order by hire_date", 
//				
//				new RowMapper<Employees>() {
//			@Override
//			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Employees e = null;
//
//				e = new Employees();
//				e.setEmployeeId(rs.getInt(1));
//				e.setLastName(rs.getString(2));
//				e.setSalary(rs.getDouble(3));
//				e.setJobId(rs.getString(4));
//				e.setHireDate(rs.getDate(5));
//				return e;
//			}
//		},new Object[] {new SimpleDateFormat("yyyy-MM-dd").parse("1996-01-01"),new SimpleDateFormat("yyyy-MM-dd").parse("1997-12-31")});
//		

//		List<Employees> empList=jdbcTemplate.query("select employee_id,last_name,salary,job_id,hire_date from employees where job_id=? and salary > ?",
//				new PreparedStatementSetter() {
//
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//						ps.setString(1, "IT_PROG");
//						ps.setDouble(2, 5000);
//
//					}
//
//				}, new RowMapper<Employees>() {
//					@Override
//					public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Employees e = null;
//
//						e = new Employees();
//						e.setEmployeeId(rs.getInt(1));
//						e.setLastName(rs.getString(2));
//						e.setSalary(rs.getDouble(3));
//						e.setJobId(rs.getString(4));
//						e.setHireDate(rs.getDate(5));
//						return e;
//					}
//				});
//		empList.forEach(x -> System.out.println(x));

//		List<Employees> empList = jdbcTemplate.query (
//				"select e.employee_id,e.last_name,e.salary,e.job_id,e.hire_date, e.department_id,d.department_name from employees e inner join departments d using(department_id)",
//				new RowMapper<Employees>() {
//
//					@Override
//					public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Employees e = null;
//						Departments d = null;
//
//						e = new Employees();
//						e.setEmployeeId(rs.getInt(1));
//						e.setLastName(rs.getString(2));
//						e.setSalary(rs.getDouble(3));
//						e.setJobId(rs.getString(4));
//						e.setHireDate(rs.getDate(5));
//						d = new Departments();
//						d.setDepartmentId(rs.getInt(6));
//						d.setDepartmentName(rs.getString(7));
//						e.setDepartments(d);
//
//						return e;
//					}
//
//				});
//		empList.forEach(x -> System.out.println(x));

		/*
		 * jdbcTemplate.
		 * query("select e.employee_id,e.last_name,e.salary,e.job_id,e.hire_date, e.department_id,d.department_name from employees e inner join departments d using(department_id)"
		 * , new RowCallbackHandler() {
		 * 
		 * @Override public void processRow(ResultSet rs) throws SQLException {
		 * System.out.println(rs.getInt(1));
		 * 
		 * }
		 * 
		 * 
		 * 
		 * });
		 */

//		List<Employees> empList = jdbcTemplate.query(
//				"select e.employee_id,e.last_name,e.salary,e.job_id,e.hire_date, e.department_id,d.department_name from employees e inner join departments d using(department_id)",
//				new ResultSetExtractor<List<Employees>>() {
//
//					@Override
//					public List<Employees> extractData(ResultSet rs) throws SQLException, DataAccessException {
//						Employees e = null;
//						Departments d = null;
//						List<Employees> empList = new ArrayList<>();
//						while (rs.next()) {
//							e = new Employees();
//							e.setEmployeeId(rs.getInt(1));
//							e.setLastName(rs.getString(2));
//							e.setSalary(rs.getDouble(3));
//							e.setJobId(rs.getString(4));
//							e.setHireDate(rs.getDate(5));
//							d = new Departments();
//							d.setDepartmentId(rs.getInt(6));
//							d.setDepartmentName(rs.getString(7));
//							e.setDepartments(d);
//							empList.add(e);
//
//						}
//						return empList;
//					}
//
//				});
//		empList.forEach(x -> System.out.println(x));

		// List<Employees> eList=jdbcTemplate.query("select
		// employee_id,last_name,salary,job_id,hire_date from employees where job_id=?",
		// new RowMapper<Employees>() {
//
//			@Override
//			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Employees e=new Employees();
//				e.setEmployeeId(rs.getInt(1));
//				e.setLastName(rs.getString(2));
//				e.setJobId(rs.getString(4));
//				e.setSalary(rs.getDouble(3));
//				e.setHireDate(rs.getDate(5));
//				return e;
//			}
//			
//		}, "IT_PROG");

//		List<Employees> eList=jdbcTemplate.query("select employee_id,last_name,salary,job_id,hire_date from employees where job_id=?", new BeanPropertyRowMapper<>(Employees.class), "IT_PROG");

//		List<Employees> el=jdbcTemplate.queryForList("select * from employees",Employees.class);
//		
//		System.out.println(el);
//		
//		
//		

//		List<Employees> eList=jdbcTemplate.query("select employee_id,last_name,salary,job_id,hire_date from employees where job_id=?", 
//		
//			(rs, rowNum) -> {
//				Employees e=new Employees();
//				e.setEmployeeId(rs.getInt(1));
//				e.setLastName(rs.getString(2));
//				e.setJobId(rs.getString(4));
//				e.setSalary(rs.getDouble(3));
//				e.setHireDate(rs.getDate(5));
//				return e;
//			}
//			
//		, "IT_PROG");
//		
//		
//		
//		
//		eList.forEach(x->System.out.println(x));

//		Employees e=jdbcTemplate.queryForObject("select employee_id,last_name,salary,job_id,hire_date from employees where employee_id=101",
//				new RowMapper<Employees>() {
//
//					@Override
//					public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Employees e=new Employees();
//						e.setEmployeeId(rs.getInt(1));
//						e.setLastName(rs.getString(2));
//						e.setJobId(rs.getString(4));
//						e.setSalary(rs.getDouble(3));
//						e.setHireDate(rs.getDate(5));
//						return e;
//					}
//			
//		});
//		Employees e=jdbcTemplate.queryForObject("select employee_id,last_name,salary,job_id from employees where employee_id=101",
//				new BeanPropertyRowMapper<>(Employees.class));

//		List<Map<String, Object>> res = jdbcTemplate.queryForList("select employee_id,last_name from employees");
//		
//		for(Map<String,Object> x:res) {
//			System.out.println(x.get("employee_id")+" "+x.get("last_name"));
//		}
//		

//		List<Map<String,Object>> res=jdbcTemplate.queryForList("select employee_id from employees where job_id=?",new RowMapper<Employees>() {
//
//			@Override
//			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Employees e=new Employees();
//				e.setEmployeeId(rs.getInt(1));
//				return e;
//			}
//			
//		},"IT_PROG");

//		for(Map<String,Object> x:res) {
//			System.out.println(x.get("employee_id"));
//		}

//		System.out.println(e);
		return "test";
	}

}
