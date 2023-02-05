package org.example.repository.Abstract;

import org.example.core.Company;


import java.util.List;

public interface ICompanyRepository {
    void addCompany(Company company);
    void removeCompany(Company company);
    List<Company> getAllCompanys();
}
