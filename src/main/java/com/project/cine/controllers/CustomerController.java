package com.project.cine.controllers;

import com.project.cine.models.CustomerModel;
import com.project.cine.services.CustomerService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ArrayList<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public CustomerModel saveCustomer(@RequestBody CustomerModel customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping(path = "/{id}")
    public Optional<CustomerModel> getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long id) {
        return customerService.deleteCustomer(id);
    }
}