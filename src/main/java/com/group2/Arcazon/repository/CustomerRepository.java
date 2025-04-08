package com.group2.Arcazon.repository;

import com.group2.Arcazon.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContaining(String domain);  
    List<Customer> findByLastNameContainingIgnoreCase(String name);
}