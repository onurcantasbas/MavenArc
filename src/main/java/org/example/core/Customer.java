package org.example.core;

import jakarta.annotation.Generated;
import lombok.Builder;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Customer {
    private Long id;
    private String name;
    private final String createdDate;
    private List<Bill> customersBillList;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.customersBillList = new ArrayList<>();
    }

    public Customer(Long id, String name, String createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.customersBillList = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomersBillList(List<Bill> billList) {this.customersBillList = billList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedDate() {return createdDate;}

    public List<Bill> getCustomersBillList() {return customersBillList;}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
