package tech.csm.dao;

import jakarta.annotation.Nullable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import tech.csm.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SimpleJdbcCall jdbcCall;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("crud_operation")
                .declareParameters(
                        new SqlParameter("operation", Types.VARCHAR),
                        new SqlParameter("table_name", Types.VARCHAR),
                        new SqlParameter("dept_id", Types.INTEGER),
                        new SqlParameter("dept_name", Types.VARCHAR),
                        new SqlParameter("emp_id", Types.INTEGER),
                        new SqlParameter("emp_name", Types.VARCHAR),
                        new SqlParameter("emp_hire_date", Types.DATE),
                        new SqlParameter("emp_salary", Types.DECIMAL),
                        new SqlParameter("emp_employment_type", Types.VARCHAR),
                        new SqlParameter("emp_dept_id", Types.INTEGER),
                        new SqlParameter("emp_is_delete", Types.CHAR)
                );
    }

    @Override
    public int insertEmployee(Employee employee) {
        Map<String, Object> inParams = createInputParams("CREATE", "employees", employee);
        executeCall(inParams, "insertion");
        return 1; // Assuming successful insert
    }

    @Override
    public Employee findEmployeeById(int empId) {
        Map<String, Object> inParams = createInputParams("READ", "employees", null);
        inParams.put("emp_id", empId); // Only set the emp_id

        try {
            Map<String, Object> out = jdbcCall
                    .returningResultSet("result", new EmployeeRowMapper()) // Map results to Employee
                    .execute(inParams);
            List<Employee> employees = (List<Employee>) out.get("result");
            return employees.isEmpty() ? null : employees.get(0); // Return the first employee or null
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee with ID " + empId, e);
        }
    }

    @Override
    public List<Employee> findAllEmployees() {

        Map<String, Object> inParams = createInputParams("READ", "employees", null);

        try {
            Map<String, Object> out = jdbcCall
                    .returningResultSet("result", new EmployeeRowMapper()) // Map results to Employee
                    .execute(inParams);
            return (List<Employee>) out.get("result"); // Cast the result
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employees", e);
        }
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("emp_id"));
            employee.setName(rs.getString("name"));
            employee.setHireDate(rs.getDate("hire_date"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setEmploymentType(rs.getString("employment_type"));
            employee.setDeptId(rs.getInt("dept_id"));
            employee.setDeleted(rs.getString("isDelete").equals("yes"));
            return employee;
        }
    }

    @Override
    public int updateEmployee(Employee employee) {

        Map<String, Object> inParams = createInputParams("UPDATE", "employees", employee);
        executeCall(inParams, "updating");
        return 1; // Assuming successful update
    }

    @Override
    public int deleteEmployee(int empId) {

        Map<String, Object> inParams = createInputParams("DELETE", "employees", null);
        inParams.put("emp_id", empId);
        executeCall(inParams, "deletion");
        return 1; // Assuming successful deletion
    }

    private Map<String, Object> createInputParams(String operation, String tableName, @Nullable Employee employee) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("operation", operation);
        inParams.put("table_name", tableName);
        inParams.put("dept_id", null); // Unused
        inParams.put("dept_name", null); // Unused
        inParams.put("emp_id", (employee != null)? employee.getEmpId() : null);
        inParams.put("emp_name", (employee != null)? employee.getName() : null);
        inParams.put("emp_hire_date", (employee != null)? employee.getHireDate() : null);
        inParams.put("emp_salary", (employee != null)? employee.getSalary() : null);
        inParams.put("emp_employment_type", (employee != null)? employee.getEmploymentType() : null);
        inParams.put("emp_dept_id", (employee != null)? employee.getDeptId() : null);
        inParams.put("emp_is_delete", (employee != null)? (employee.isDeleted())? "yes" : "no" : null);

        return inParams;
    }

    private void executeCall(Map<String, Object> inParams, String operation) {
        try {
            jdbcCall.execute(inParams);
        } catch (Exception e) {
            throw new RuntimeException("Error during employee " + operation + " : ", e);
        }
    }
}
