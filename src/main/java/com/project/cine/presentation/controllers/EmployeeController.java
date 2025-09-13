package com.project.cine.presentation.controllers;

import com.project.cine.application.dto.EmployeeDto;
import com.project.cine.application.services.EmployeeService;
import com.project.cine.domain.models.EmployeeModel;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ArrayList<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.savaEmployee(employee);
    }

    @GetMapping(path = "/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }
}