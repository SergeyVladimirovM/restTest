package com.example.resttest.repository;

import com.example.resttest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findCustomerByFirstNameAndLastName(String firstName, String lastName);
    Customer findCustomerByLastNameAndCity(String lastName, String city);
    Customer findCustomerByFirstNameAndLastNameAndCity(String firstName, String lastName, String city);
}
