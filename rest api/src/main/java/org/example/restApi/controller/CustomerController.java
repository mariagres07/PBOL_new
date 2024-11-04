package org.example.restApi.controller;

import org.example.restApi.model.Customer;
import org.example.restApi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customer_list";
    }
    @GetMapping("/customer/new")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer_form";
    }
    @PostMapping("/customer/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @PutMapping("/customer/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Remove setting ID; it's auto-generated
            customerRepository.save(existingCustomer);
        }
        return "redirect:/customers";
    }

    @DeleteMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerRepository.deleteById(id);
        return "redirect:/customers";
    }
}

