package com.HRMS.controller;

import com.HRMS.entity.Company;
import com.HRMS.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees")
    public List<Company> findAllEmployee(){
        return companyService.getEmployees();
    }

    @GetMapping("/employeeById/{id}")
    public Company getCompanyById(@PathVariable long id){
        return companyService.getCompanyById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        return companyService.deleteEmployee(id);
    }

    @PutMapping ("/updateEmployee")
    public Company updateEmployee(@RequestBody Company company){
        return companyService.updateEmployee(company);
    }
}
