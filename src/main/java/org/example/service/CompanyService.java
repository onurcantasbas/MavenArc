package org.example.service;

import org.example.core.Bill;
import org.example.core.Company;
import org.example.repository.Abstract.ICompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public void addCompany(Company company){companyRepository.addCompany(company);}
    public void removeCompany(Company company){companyRepository.removeCompany(company);}
    public List<Company> getAllCompanys(){return companyRepository.getAllCompanys();}


    public List<Company> getAverageCompanyBillsByMounth(String mounth,double average){
      return   getAllCompanys().stream()
              .filter(company -> company.getCompanyBills()
                      .stream()
                      .filter(bill -> bill.getCreateDate()
                              .split("-")[1].equals(mounth))
                      .mapToInt(Bill::getPrice).average()
                      .getAsDouble()<750.0)
              .collect(Collectors.toList());
    }

}
