package com.HRMS.service;

import com.HRMS.entity.Company;
import com.HRMS.repository.CompanyRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Company> saveEmployees(List<Company> companies) {
        List<Company> savedCompanies = new ArrayList<>(); // To store the companies with createdDate set
        for (Company company : companies) {
            company.setCreatedDate(new Date());
            savedCompanies.add(company);
        }
        return companyRepository.saveAll(savedCompanies);
    }

    public List<Company> getEmployees(){
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id){
        return companyRepository.findById((long)id).orElse(null);
    }
    public String deleteEmployee(int id){
        companyRepository.deleteById((long)id);
        return "employee removed !! "+id;
    }
    public Company updateEmployee(Company company) {
        Company existingEmployee = companyRepository.findById(company.getId()).orElse(null);
        existingEmployee.setNo(company.getNo());
        existingEmployee.setDescription(company.getDescription());
        existingEmployee.setStatus(company.getStatus());
        return companyRepository.save(existingEmployee);
    }
}
