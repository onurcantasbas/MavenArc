package org.example.repository.Abstract;

import org.example.core.Customer;

import java.util.List;

public interface ICustomerRepository {

    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getAllCustomer();

}
