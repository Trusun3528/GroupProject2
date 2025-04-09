package com.group2.Arcazon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.Arcazon.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContaining(String domain);  
    List<Customer> findByLastNameContainingIgnoreCase(String name);
    List<Customer> findByFirstNameContainingIgnoreCase(String name);
    Customer findByEmail(String email);
    boolean existsByEmail(String email);
    List<Customer> findByFirstNameOrLastNameIgnoreCase(String keyword);
    List<Customer> findByAddressContainingIgnoreCase(String address);
    List<Customer> findByActive(boolean active);
    Customer save(Customer customer);
}