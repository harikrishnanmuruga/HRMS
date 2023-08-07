package com.HRMS.service;

import com.HRMS.entity.Company;
import com.HRMS.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public Company saveEmployee(Company company){
        company.setCreatedDate(new Date());
        return companyRepository.save(company);
    }
    public List<Company> saveEmployees(List<Company> company){
        return companyRepository.saveAll(company);
    }
}
