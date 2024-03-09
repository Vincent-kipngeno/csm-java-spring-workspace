package tech.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.csm.model.Department;
import tech.csm.model.Employee;
import tech.csm.service.DepartmentService;
import tech.csm.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getForm")
    public String getEmployeeForm(Model model) {
        return "salesform";
    }

    // CREATE
    @PostMapping("/")
    public ResponseEntity<Integer> createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(1); // Record inserted
    }

    // READ
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PostMapping("/update/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    // DELETE
    @GetMapping("/delete/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.noContent().build();
    }
}