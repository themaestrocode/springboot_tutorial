package com.themaestrocode.springboot.tutorial.service;

import com.themaestrocode.springboot.tutorial.entity.Department;
import com.themaestrocode.springboot.tutorial.error.DepartmentNotFoundException;
import org.aspectj.lang.reflect.DeclareAnnotation;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

}
