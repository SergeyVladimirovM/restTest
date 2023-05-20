package com.example.resttest.controller;

import com.example.resttest.dto.CustomerInput;
import com.example.resttest.entity.Customer;
import com.example.resttest.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("api/v1/customer")
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomer();
    }

    @PostMapping("/")
    public UUID saveCustomer(@RequestBody CustomerInput customerInput) {
        Customer customer = new Customer();
        customer.setFirstName(customerInput.getFirstName());
        customer.setLastName(customerInput.getLastName());
        customer.setCity(customerInput.getCity());
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("/by-first-name-last-name")
    public Customer getCustomerByFirstNameAndLastName(@RequestBody CustomerInput customerInput) {
        return customerService.findCustomerByFirstNameAndLastName(
                customerInput.getFirstName(),
                customerInput.getLastName()
        );
    }

    @PostMapping("/by-last-name-city")
    public Customer getCustomerByLastNameAndCity(@RequestBody CustomerInput customerInput) {
        return customerService.findCustomerByLastNameAndCity(
                customerInput.getLastName(),
                customerInput.getCity()
        );
    }

    @PostMapping("/by-first-name-last-name-city")
    public Customer getCustomerByFirstNameAndLastNameAndCity(@RequestBody CustomerInput customerInput) {
        return customerService.findCustomerByFirstNameAndLastNameAndCity(
                customerInput.getFirstName(),
                customerInput.getLastName(),
                customerInput.getCity()
        );
    }
}
