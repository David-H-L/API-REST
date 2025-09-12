package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.EmployeeModel;
import com.project.cine.domain.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ArrayList<EmployeeModel> getAllEmployee() {
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel savaEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    public Optional<EmployeeModel> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public boolean deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
