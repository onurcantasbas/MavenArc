package org.example.core;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private Long id;
    private String name;
    private String sector;
    private List<Bill> companyBills;

    public Company(Long id, String name, String sector) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.companyBills = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Bill> getCompanyBills() {
        return companyBills;
    }

    public void setCompanyBills(List<Bill> companyBills) {
        this.companyBills = companyBills;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", companyBills=" + companyBills +
                '}';
    }
}

