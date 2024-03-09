package tech.csm.dao;

import tech.csm.model.Department;

import java.util.List;

public interface DepartmentDAO {

    int insertDepartment(Department department);

    Department findDepartmentById(int deptId);

    List<Department> findAllDepartments();

    int updateDepartment(Department department);

    int deleteDepartment(int deptId);
}