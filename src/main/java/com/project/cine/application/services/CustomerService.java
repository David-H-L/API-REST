package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.CustomerModel;
import com.project.cine.domain.repositories.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ArrayList<CustomerModel> getAllCustomers() {
        return (ArrayList<CustomerModel>) customerRepository.findAll();
    }

    public CustomerModel saveCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public Optional<CustomerModel> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
