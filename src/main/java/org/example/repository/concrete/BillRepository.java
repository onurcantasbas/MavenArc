package org.example.repository.concrete;

import org.example.core.Bill;
import org.example.repository.Abstract.IBillRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BillRepository implements IBillRepository {
    private static List<Bill> billList = new ArrayList<>();


    @Override
    public void addBill(Bill bill) {
        billList.add(bill);
    }

    @Override
    public void removeBill(Bill bill) {
        billList.remove(bill);
    }

    @Override
    public List<Bill> getAllBills() {return billList;}
}
