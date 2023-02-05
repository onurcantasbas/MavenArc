package org.example.repository.concrete;


import org.example.core.Customer;
import org.example.repository.Abstract.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    // DATABASE
    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerList;
    }


}
