package org.example.repository.Abstract;

import org.example.core.Bill;

import java.util.List;

public interface IBillRepository  {

    void addBill(Bill bill);
    void removeBill(Bill bill);
    List<Bill> getAllBills();
}
