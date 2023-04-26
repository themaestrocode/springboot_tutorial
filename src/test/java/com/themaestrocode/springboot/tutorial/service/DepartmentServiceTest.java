package com.themaestrocode.springboot.tutorial.service;

import com.themaestrocode.springboot.tutorial.entity.Department;
import com.themaestrocode.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Computer Science")
                .departmentId(1L)
                .departmentAddress("Akungba-Akoko")
                .departmentCode("CSC")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Computer Science")).thenReturn(department);
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
    }

    // test for fetchDepartmentByName() method
    @Test
    @DisplayName("Get Department based on valid name")
    public void whenValidDepartName_thenDepartmentShouldFound() {
        String departmentName = "Computer Science";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }

    //test for saveDepartment
    @Test
    @DisplayName("Save Department based on valid data")
    public void whenValidDepartmentProvided_thenDepartmentShouldSave() {
        Department department
                = new Department(1L, "Computer Science", "Akungba", "CSC");

        List<Department> save = new ArrayList<>();
        save.add(department);
    }
}