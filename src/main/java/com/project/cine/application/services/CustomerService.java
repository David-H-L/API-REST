package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.application.dto.CustomerDto;
import com.project.cine.domain.models.CustomerModel;
import com.project.cine.domain.repositories.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ArrayList<CustomerDto> getAllCustomers() {

        ArrayList<CustomerModel> AllCustomers = (ArrayList<CustomerModel>) customerRepository.findAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        for (CustomerModel customer : AllCustomers) {
            customerDtos.add(new CustomerDto(customer.getName(), customer.getAge(), customer.getEmail(),
                    customer.getCustomerPoints()));
        }

        return customerDtos;
    }

    public CustomerModel saveCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public CustomerDto getCustomerById(Long id) {
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new EntityNotFoundException("Customer not found with id: " + id);
        }
        CustomerModel customerDB = customer.get();
        return new CustomerDto(customerDB.getName(), customerDB.getAge(), customerDB.getEmail(),
                customerDB.getCustomerPoints());
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
