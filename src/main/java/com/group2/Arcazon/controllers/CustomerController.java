package com.group2.Arcazon.controllers;

import com.group2.Arcazon.model.Customer;
import com.group2.Arcazon.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "customer-search";
    }

    @PostMapping("/search/email")
    public String searchByEmailDomain(@RequestParam String domain, Model model) {
        List<Customer> customers = customerService.findByEmailContaining(domain);
        model.addAttribute("customers", customers);
        model.addAttribute("searchType", "email domain: " + domain);
        return "customer-results";
    }

    @PostMapping("/search/name")
    public String searchByName(@RequestParam String name, Model model) {
        List<Customer> customers = customerService.findByFirstNameOrLastNameIgnoreCase(name, name);
        model.addAttribute("customers", customers);
        model.addAttribute("searchType", "name: " + name);
        return "customer-results";
    }
}