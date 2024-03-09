package tech.csm.service;

import tech.csm.model.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartmentById(int deptId);
    List<Department> getAllDepartments();
    Department updateDepartment(Department department);
    void deleteDepartment(int deptId);
}
