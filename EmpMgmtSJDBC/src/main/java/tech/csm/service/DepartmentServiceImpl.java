package tech.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.csm.dao.DepartmentDAO;
import tech.csm.model.Department;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public Department saveDepartment(Department department) {
        departmentDAO.insertDepartment(department);
        return department;
    }

    @Override
    public Department getDepartmentById(int deptId) {
        return departmentDAO.findDepartmentById(deptId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAllDepartments();
    }

    @Override
    public Department updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
        return department;
    }

    @Override
    public void deleteDepartment(int deptId) {
        departmentDAO.deleteDepartment(deptId);
    }
}