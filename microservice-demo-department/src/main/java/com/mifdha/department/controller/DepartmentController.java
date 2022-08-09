package com.mifdha.department.controller;

import com.mifdha.department.model.Department;
import com.mifdha.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create-department")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/get-department/{id}")
    public Department getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/get-all")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/delete-department/{id}")
    public String deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartment(id);
    }

    @PutMapping("/edit-department")
    public Department editDepartment(@RequestBody Department department){
        return departmentService.editDepartment(department);
    }
}
