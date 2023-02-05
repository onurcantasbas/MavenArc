package org.example.service;

import org.example.core.Bill;
import org.example.repository.Abstract.IBillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService{
    private final IBillRepository billRepository;

    public BillService(IBillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void addBill(Bill bill){billRepository.addBill(bill);}
    public void removeBill(Bill bill){billRepository.removeBill(bill);}
    public List<Bill> getAllBills(){return billRepository.getAllBills();}
    public List<Bill> findBillsByPriceHigher(int price){
       return getAllBills().stream().filter(bill -> bill.getPrice()>1500).collect(Collectors.toList());
    }
    public double getAverageBillsByPriceHigher(int price){
       return findBillsByPriceHigher(price).stream().mapToInt(Bill::getPrice).average().orElse(0);
    }
    public List<Bill> findBillsByPriceLower(int price){
        return getAllBills().stream().filter(bill -> bill.getPrice()<price).collect(Collectors.toList());
    }
}
