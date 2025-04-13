package com.group2.Arcazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.Arcazon.model.Customer;
import com.group2.Arcazon.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> findByEmailContaining(String domain) {
        return customerRepository.findByEmailContaining(domain);
    }
    public List<Customer> findByLastNameContainingIgnoreCase(String name) {
        return customerRepository.findByLastNameContainingIgnoreCase(name);
    }

    public List<Customer> findByFirstNameContainingIgnoreCase(String name) {
        return customerRepository.findByFirstNameContainingIgnoreCase(name);
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    public List<Customer> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName) {
        return customerRepository.findByFirstNameOrLastNameIgnoreCase(firstName, lastName);
    }


    public List<Customer> findByAddressLine1ContainingIgnoreCase(String addressLine1) {
        return customerRepository.findByAddressLine1ContainingIgnoreCase(addressLine1);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}
