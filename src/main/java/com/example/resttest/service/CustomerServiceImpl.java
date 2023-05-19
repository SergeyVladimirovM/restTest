package com.example.resttest.service;

import com.example.resttest.entity.Customer;
import com.example.resttest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer findCustomerByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findCustomerByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Customer findCustomerByLastNameAndCity(String lastName, String city) {
        return customerRepository.findCustomerByLastNameAndCity(lastName, city);
    }

    @Override
    public Customer findCustomerByFirstNameAndLastNameAndCity(String firstName, String lastName, String city) {
        return customerRepository.findCustomerByFirstNameAndLastNameAndCity(firstName, lastName, city);
    }

    @Override
    public UUID saveCustomer(Customer customer) {
        return customerRepository.save(customer).getId();
    }
}
