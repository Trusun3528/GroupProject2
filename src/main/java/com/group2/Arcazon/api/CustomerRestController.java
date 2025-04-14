package com.group2.Arcazon.api;

import com.group2.Arcazon.model.Customer;
import com.group2.Arcazon.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/search/email/{domain}")
    public List<Customer> findByEmailDomain(@PathVariable String domain) {
        return customerService.findByEmailContaining(domain);
    }

    @GetMapping("/search/name/{name}")
    public List<Customer> findByName(@PathVariable String name) {
        return customerService.findByFirstNameOrLastNameIgnoreCase(name, name);
    }
}