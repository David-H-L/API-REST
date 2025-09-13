package com.project.cine.presentation.controllers;

import com.project.cine.application.dto.CustomerDto;
import com.project.cine.application.services.CustomerService;
import com.project.cine.domain.models.CustomerModel;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ArrayList<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public CustomerModel saveCustomer(@RequestBody CustomerModel customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping(path = "/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long id) {
        return customerService.deleteCustomer(id);
    }
}