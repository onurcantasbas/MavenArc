package org.example.core;

import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Bill {
    private Long id;
    private int price;
    private Company company;
    private Customer customer;
    private final String createDate;

    public Bill(Long id, int price, Company company,Customer customer) {
        this.id = id;
        this.price = price;
        this.company = company;
        this.createDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.customer = customer;
    }

    public Bill(Long id, int price, Company company,Customer customer, String createDate){
        this.id = id;
        this.price = price;
        this.company = company;
        this.customer = customer;
        this.createDate = createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Long getId() {
        return id;
    }
    public Customer getCustomer() {return customer;}
    public int getPrice() {
        return price;
    }
    public Company getCompany() {
        return company;
    }
    public String getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", price=" + price +
                ", company=" + company.getName() +
                ", customer=" + customer.getName() +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
