package com.mifdha.department.service;

import com.mifdha.department.model.Department;
import com.mifdha.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(int id){
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public String deleteDepartment(int id){
        departmentRepository.deleteById(id);
        return "department deleted successfully";
    }

    public Department editDepartment(Department department){
        Department existingDepartment = getDepartmentById(department.getId());
        existingDepartment.setName(department.getName());
        return departmentRepository.save(existingDepartment);
    }

}
