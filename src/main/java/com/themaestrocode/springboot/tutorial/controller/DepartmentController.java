package com.themaestrocode.springboot.tutorial.controller;

import com.themaestrocode.springboot.tutorial.entity.Department;
import com.themaestrocode.springboot.tutorial.error.DepartmentNotFoundException;
import com.themaestrocode.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    /**
     * method to save a new department by calling the saveDepartment() method in DepartmentService class and returning its object.
     * @param department
     * @return
     */
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        /* adding a Logger */
        LOGGER.info("inside the saveDepartment method of DepartmentController class...");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("inside the fetchDepartmentList method of DepartmentController class...");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "department successfully deleted!\nMethod of deletion: BY ID";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName (@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
