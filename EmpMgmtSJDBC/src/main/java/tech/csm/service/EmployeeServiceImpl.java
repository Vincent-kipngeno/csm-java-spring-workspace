package tech.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.csm.dao.EmployeeDAO;
import tech.csm.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
        return employee; // Return the inserted employee (with generated ID, if applicable)
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeDAO.findEmployeeById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
        return employee; // Return the updated employee
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeDAO.deleteEmployee(empId);
    }
}