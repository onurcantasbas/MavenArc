package org.example.service;

import org.example.core.Bill;
import org.example.core.Customer;
import org.example.repository.Abstract.ICustomerRepository;
import org.example.repository.concrete.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(String name){
         Long id =Long.valueOf((customerRepository.getAllCustomer().size()+1));
         customerRepository.addCustomer(new Customer(id,name));
    }
    public void addCustomer(String name, String date){
        Long id =Long.valueOf((customerRepository.getAllCustomer().size()+1));
        customerRepository.addCustomer(new Customer(id,name,date));
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomer();
    }

    public List<Customer> findCustomerByChar(CharSequence c){
       return getAllCustomers().stream().filter(customer -> customer.getName().toLowerCase().contains(c)).collect(Collectors.toList());
    }

    public HashMap<Customer,Integer> sumCustomersBillsByCreatedDate(String month){
         List<Customer> customersCreatedAt = getAllCustomers().stream()
                 .filter(customer -> customer.getCreatedDate()
                         .split("-")[1].equals(month))
                 .collect(Collectors.toList());
         HashMap<Customer,Integer> customerBillsSum = new HashMap<>();
         int sum;
         for (Customer customer: customersCreatedAt
             ) {
            sum = 0;
            for (Bill bill : customer.getCustomersBillList()
                    ) {
                sum += bill.getPrice();
            }
            customerBillsSum.put(customer,sum);
        }
//
        return customerBillsSum;
    }

}
