package com.HRMS.controller;

import com.HRMS.entity.Company;
import com.HRMS.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/createEmployee")
    public Company createEmployee(@RequestBody Company company) {
        return companyService.saveEmployee(company);
    }

        @PostMapping("/createEmployees")
        public List<Company> createEmployees(@RequestBody List<Company> employees) {
            return companyService.saveEmployees(employees);
        }
    }
