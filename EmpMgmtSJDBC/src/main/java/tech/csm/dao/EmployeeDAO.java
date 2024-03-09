package tech.csm.dao;

import tech.csm.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    int insertEmployee(Employee employee);

    Employee findEmployeeById(int empId);

    List<Employee> findAllEmployees();

    int updateEmployee(Employee employee);

    int deleteEmployee(int empId);
}
