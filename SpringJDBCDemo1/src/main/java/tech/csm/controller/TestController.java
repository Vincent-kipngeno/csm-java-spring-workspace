package tech.csm.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tech.csm.domain.Employees;

@Controller
public class TestController {

	@Value("${udb.url}")
	private String url;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/getdata")
	public String getData() throws DataAccessException, ParseException {

		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		
//		Map<String,Object> pMap=new HashMap<>();
//		pMap.put("empId", 101);
		
//		Employees emp=namedParameterJdbcTemplate.queryForObject(
//				"select employee_id,last_name,salary,job_id,hire_date from semp where employee_id=:empId", 
//				new MapSqlParameterSource().addValue("empId", 101),
//				new BeanPropertyRowMapper<>(Employees.class));
//		Map<String,Object> mp=new HashMap<>();
//		mp.put("job_id", "IT_PROG");
//		new MapSqlParameterSource().addValue("job_id", "IT_PROG");
		List<Employees> empList=namedParameterJdbcTemplate.query("select employee_id,last_name,salary,job_id,hire_date from semp where job_id=:job_id",
				new MapSqlParameterSource().addValue("job_id", "IT_PROG")
				,new RowMapper<Employees>() {

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
		
		
		
		
		
		
		
//		List<Employees> empList = jdbcTemplate.execute("{call p_semp_proc('se')}",
//				new CallableStatementCallback<List<Employees>>() {
//
//					@Override
//					public List<Employees> doInCallableStatement(CallableStatement cs)
//							throws SQLException, DataAccessException {
//
//						ResultSet rs = cs.executeQuery();
//						List<Employees> empList = null;
//						if (rs.next()) {
//							empList = new ArrayList<>();
//							do {
//								Employees e = new Employees();
//								e.setEmployeeId(rs.getInt(1));
//								e.setLastName(rs.getString(2));
//								e.setSalary(rs.getDouble(3));
//								e.setJobId(rs.getString(4));
//								e.setHireDate(rs.getDate(5));
//								empList.add(e);
//							} while (rs.next());
//						}
//
//						return empList;
//					}
//				});
		
		
		
		
		
		
		
		
		
		

//		Integer rc=jdbcTemplate.execute(new CallableStatementCreator() {
//			
//			@Override
//			public CallableStatement createCallableStatement(Connection con) throws SQLException {
//				CallableStatement pc = con.prepareCall("{call p_semp_proc(?,?,?,?,?)}");
//				pc.setString(1, "in");
//				pc.setString(2, "Anil Sahu");
//				pc.setDouble(3, 7655.00);
//				pc.setString(4, "IT_PROG");
//				try {
//					pc.setDate(5, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1997-09-21").getTime()));
//				} catch (SQLException | ParseException e) {
//					e.printStackTrace();
//				}
//				return pc;
//			}
//		}, new CallableStatementCallback<Integer>() {
//
//			@Override
//			public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
//				
//				Integer rc=cs.executeUpdate();
//				return rc;
//			}
//		} );
//
//		System.out.println(rc+" no of records added!!");
		
		
		
		
		
		
		
		
		

//		KeyHolder kh=new GeneratedKeyHolder();
//		
//		Integer rc=jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps = con.prepareStatement("insert into semp(last_name,salary,job_id,hire_date)values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
//				
//				ps.setString(1, "Kundan");
//				ps.setDouble(2, 5344.00);
//				ps.setString(3, "SA_REP");
//				try {
//					ps.setDate(4, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-06").getTime()));
//				} catch (SQLException | ParseException e) {
//					e.printStackTrace();
//				}
//				return ps;
//			}
//		}, kh);
//		
//		if(rc==1)
//			System.out.println("Emp saved with id : "+kh.getKey());
//		

		/*
		 * Integer nr=jdbcTemplate.update(new PreparedStatementCreator() {
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection con)
		 * throws SQLException { PreparedStatement ps = con.
		 * prepareStatement("insert into semp(employee_id,last_name,salary,job_id,hire_date)values(?,?,?,?,?)"
		 * ); ps.setInt(1, 207); ps.setString(2, "Amit Das"); ps.setDouble(3, 6400.00);
		 * ps.setString(4, "IT_PROG"); try { ps.setDate(5, new java.sql.Date(new
		 * SimpleDateFormat("yyyy-MM-dd").parse("1998-01-06").getTime())); } catch
		 * (SQLException | ParseException e) { e.printStackTrace(); } return ps; } });
		 */

//		List<Employees> empList=jdbcTemplate.query(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps = con.prepareStatement(
//						"select employee_id,last_name,salary,job_id,hire_date from semp where job_id=? and salary > ?");
//				ps.setString(1, "IT_PROG");
//				ps.setDouble(2, 5000);
//				return ps;
//			}
//		}, new RowMapper<Employees>() {
//
//			@Override
//			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Employees e = new Employees();				
//				e.setEmployeeId(rs.getInt(1));
//				e.setLastName(rs.getString(2));
//				e.setSalary(rs.getDouble(3));
//				e.setJobId(rs.getString(4));
//				e.setHireDate(rs.getDate(5));
//				return e;
//			}
//		});
//		
//		empList.forEach(x->System.out.println(x));

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
