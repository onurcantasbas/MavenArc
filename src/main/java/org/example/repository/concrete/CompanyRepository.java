package org.example.repository.concrete;


import org.example.core.Company;
import org.example.repository.Abstract.ICompanyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository implements ICompanyRepository {
    private static List<Company> companyList = new ArrayList<>();

    @Override
    public void addCompany(Company company) {
        companyList.add(company);
    }

    @Override
    public void removeCompany(Company company) {
        companyList.remove(company);
    }

    @Override
    public List<Company> getAllCompanys() {
        return companyList;
    }
}
