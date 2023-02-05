package org.example;

import org.example.core.Customer;
import org.example.service.BillService;
import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.example.config.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.HashMap;

@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    CustomerService customerService;
    @Autowired
    BillService billService;
    @Autowired
    CompanyService companyService;
    @Autowired
    Seed seed;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

        seed.createSeeds(); // Sample generator. Generates 16 customers, 6 companies, 540 bills
        System.out.println("------------- :: Tüm Müşteriler :: --------------");
        customerService.getAllCustomers().stream().forEach(customer -> System.out.println(customer.toString()));

        System.out.println("------------- :: İsminde c harfi olan kullanıcılar :: --------------");
        customerService.findCustomerByChar("c").stream().forEach(customer -> System.out.println(customer.toString()));

        System.out.println("------------- ::  Haziran Ayında Kayıt olan müşterilerin faturalarının toplamları :: --------------");
        HashMap<Customer,Integer> customersByCreatedAt = customerService.sumCustomersBillsByCreatedDate("06");
        for (Customer customer:customersByCreatedAt.keySet()
             ) {
            System.out.println(customer.toString()+"  Faturaları toplamı :"+ customersByCreatedAt.get(customer).toString());
        }

        System.out.println("------------- ::  Sistemdeki Tüm Faturalar :: --------------");
        billService.getAllBills().stream().forEach(bill -> System.out.println(bill.toString()));

        System.out.println("------------- ::  Sistemdeki 1500 tl üzeri Faturalar :: --------------");
        billService.findBillsByPriceHigher(1500).stream().forEach(bill -> System.out.println(bill.toString()));

        System.out.println("------------- ::  Sistemdeki 1500 tl üzeri Faturaların Ortalaması :: --------------");
        System.out.println(billService.getAverageBillsByPriceHigher(1500));

        System.out.println("------------- ::  Sistemdeki 500 tl altındaki Faturalara sahip müşteriler :: --------------");
        billService.findBillsByPriceLower(500).stream().forEach(bill -> System.out.println(bill.getCustomer().getName()));

        System.out.println("------------- ::  Haziran ayın faturaları ortalaması 750 altı olan firmaların sektörleri :: --------------");
        companyService.getAverageCompanyBillsByMounth("06",750.0).stream().forEach(company -> System.out.println(company.getSector()));

        System.out.println("Faturaların fiyat değeri Math.random ile üretilmektedir bazı kriterler boş dönebilir.");
        
    }
}
