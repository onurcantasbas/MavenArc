package org.example.config;

import org.example.core.Bill;
import org.example.core.Company;
import org.example.core.Customer;
import org.example.service.BillService;
import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.springframework.context.annotation.Configuration;
import java.text.ParseException;

@Configuration
public class Seed {
    private final CustomerService customerService;
    private final CompanyService companyService;
    private final BillService billService;


    public Seed(CustomerService customerService, CompanyService companyService, BillService billService) {
        this.customerService = customerService;
        this.companyService = companyService;
        this.billService = billService;
    }

    public void createCustomerSeed(){
        customerService.addCustomer("CustN0");
        customerService.addCustomer("CustN1");
        customerService.addCustomer("CustN2");
        customerService.addCustomer("CustN3");
        customerService.addCustomer("CustN4");
        customerService.addCustomer("CustN5");
        customerService.addCustomer("CustN6");
        customerService.addCustomer("CustN7");
        customerService.addCustomer("CustN8");
        customerService.addCustomer("CustN9");
        customerService.addCustomer("CustN10");
        customerService.addCustomer("CustN11");
    }
    public void createCustomerSeedForJune() throws ParseException {
        String dateInString = "2022-06-01";
        customerService.addCustomer("CustP0",dateInString);
        customerService.addCustomer("CustP1",dateInString);
        customerService.addCustomer("CustP2",dateInString);
        customerService.addCustomer("CustP3",dateInString);
        customerService.addCustomer("CustP4",dateInString);
        customerService.addCustomer("CustP5",dateInString);

  }
    public void createCompanySeed(){
        companyService.addCompany(new Company(Long.valueOf((companyService.getAllCompanys().size()+1)),"Comp1","Technology"));
        companyService.addCompany(new Company(Long.valueOf((companyService.getAllCompanys().size()+1)),"Comp2","Technology"));
        companyService.addCompany(new Company(Long.valueOf((companyService.getAllCompanys().size()+1)),"Comp3","Accessory"));
        companyService.addCompany(new Company(Long.valueOf((companyService.getAllCompanys().size()+1)),"Comp4","Medical"));
        companyService.addCompany(new Company(Long.valueOf((companyService.getAllCompanys().size()+1)),"Comp3","Accessory"));
        companyService.addCompany(new Company(Long.valueOf((companyService.getAllCompanys().size()+1)),"Comp4","Medical"));
    }

    public void createBillSeed(){
        int companyListSize = companyService.getAllCompanys().size();
        int customerListSize = customerService.getAllCustomers().size();
        for(int i=0;i<companyListSize;i++){
            for (int j=0;j<customerListSize;j++){
                for (int k=0;k<5;k++){
                    int price =(int) (Math.random() * 1500) + 100;
                    Customer customer = customerService.getAllCustomers().get(j);
                    Company company = companyService.getAllCompanys().get(i);
                    Bill bill = new Bill(Long.valueOf((billService.getAllBills().size()+1)),price,company,customer);
                    company.getCompanyBills().add(bill);
                    customer.getCustomersBillList().add(bill);
                }
            }
        }
    }
    public void createBillSeedForJune(){
        int companyListSize = companyService.getAllCompanys().size();
        int customerListSize = customerService.getAllCustomers().size();
        String dateInString = "2022-06-01";
        for(int i=0;i<companyListSize;i++){
            for (int j=0;j<customerListSize;j++){
                for (int k=0;k<5;k++){
                    int price =(int) (Math.random() * 1500) + 100;
                    Customer customer = customerService.getAllCustomers().get(j);
                    Company company = companyService.getAllCompanys().get(i);
                    Bill bill = new Bill(Long.valueOf((billService.getAllBills().size()+1)),price,company,customer,dateInString);
                    company.getCompanyBills().add(bill);
                    customer.getCustomersBillList().add(bill);
                    billService.getAllBills().add(bill);
                }
            }
        }
    }
    public void createSeeds() throws ParseException {
        createCustomerSeed();
        createCustomerSeedForJune();
        createCompanySeed();
        createBillSeed();
        createBillSeedForJune();
    }

}
