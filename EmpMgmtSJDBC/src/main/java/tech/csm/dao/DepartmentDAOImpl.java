package tech.csm.dao;

import jakarta.annotation.Nullable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import tech.csm.model.Department;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class DepartmentDAOImpl implements DepartmentDAO {


    private final SimpleJdbcCall jdbcCall;

    public DepartmentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("crud_operation") // Assuming same stored procedure for departments
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
    public int insertDepartment(Department department) {
        Map<String, Object> inParams = createInputParams("CREATE", "departments", department);
        executeCall(inParams, "insertion");
        return 1; // Assuming successful insert
    }

    @Override
    public Department findDepartmentById(int deptId) {
        Map<String, Object> inParams = createInputParams("READ", "departments", null);
        inParams.put("dept_id", deptId); // Only set the dept_id

        try {
            Map<String, Object> out = jdbcCall
                    .returningResultSet("result", new DepartmentRowMapper())
                    .execute(inParams);
            List<Department> departments = (List<Department>) out.get("result");
            return departments.isEmpty() ? null : departments.get(0);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching department with ID " + deptId, e);
        }
    }

    @Override
    public List<Department> findAllDepartments() {
        Map<String, Object> inParams = createInputParams("READ", "departments", null);

        try {
            Map<String, Object> out = jdbcCall
                    .returningResultSet("result", new DepartmentRowMapper())
                    .execute(inParams);
            return (List<Department>) out.get("result");
        } catch (Exception e) {
            throw new RuntimeException("Error fetching departments", e);
        }
    }

    @Override
    public int updateDepartment(Department department) {
        Map<String, Object> inParams = createInputParams("UPDATE", "departments", department);
        executeCall(inParams, "updating");
        return 1; // Assuming successful update
    }

    @Override
    public int deleteDepartment(int deptId) {
        Map<String, Object> inParams = createInputParams("DELETE", "departments", null);
        inParams.put("dept_id", deptId);
        executeCall(inParams, "deletion");
        return 1; // Assuming successful deletion
    }

    private Map<String, Object> createInputParams(String operation, String tableName, @Nullable Department department) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("operation", operation);
        inParams.put("table_name", tableName);
        inParams.put("dept_id", (department != null) ? department.getDeptId() : null);
        inParams.put("dept_name", (department != null) ? department.getName() : null);
        inParams.put("emp_id", null);
        inParams.put("emp_name", null);
        inParams.put("emp_hire_date", null);
        inParams.put("emp_salary", null);
        inParams.put("emp_employment_type", null);
        inParams.put("emp_dept_id", null);
        inParams.put("emp_is_delete", null);

        return inParams;
    }

    private void executeCall(Map<String, Object> inParams, String operation) {
        try {
            jdbcCall.execute(inParams);
        } catch (Exception e) {
            throw new RuntimeException("Error during department " + operation + " : ", e);
        }
    }

    private static class DepartmentRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();
            department.setDeptId(rs.getInt("dept_id"));
            department.setName(rs.getString("name"));
            return department;
        }
    }
}
