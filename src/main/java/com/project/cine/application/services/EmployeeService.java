package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.application.dto.EmployeeDto;
import com.project.cine.domain.models.EmployeeModel;
import com.project.cine.domain.repositories.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ArrayList<EmployeeDto> getAllEmployee() {

        ArrayList<EmployeeModel> AllEmployee = (ArrayList<EmployeeModel>) employeeRepository.findAll();
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();

        for (EmployeeModel employee : AllEmployee) {
            employeeDtos.add(new EmployeeDto(employee.getName(), employee.getAge(), employee.getEmail(),
                    employee.getSalary(), employee.getAddress(), employee.getPhoneNumber()));
        }

        return employeeDtos;
    }

    public EmployeeModel savaEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeDto getEmployeeById(Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
        EmployeeModel employeeDB = employee.get();
        return new EmployeeDto(employeeDB.getName(), employeeDB.getAge(), employeeDB.getEmail(), employeeDB.getSalary(),
                employeeDB.getAddress(), employeeDB.getPhoneNumber());
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
