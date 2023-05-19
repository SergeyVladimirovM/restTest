package com.example.resttest.service;

import com.example.resttest.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findCustomerById(UUID id);
    Customer findCustomerByFirstNameAndLastName(String firstName, String lastName);
    Customer findCustomerByLastNameAndCity(String lastName, String city);
    Customer findCustomerByFirstNameAndLastNameAndCity(String firstName, String lastName, String city);
    UUID saveCustomer(Customer customer);
}
