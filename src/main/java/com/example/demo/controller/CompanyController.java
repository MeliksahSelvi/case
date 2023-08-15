package com.example.demo.controller;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.RestResponse;
import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public RestResponse getCompanies() {
        List<CompanyDto> companyList = companyService.getCompanies();
        return RestResponse.of(companyList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RestResponse findById(@PathVariable Long id) {
        CompanyDto companyDto = companyService.findById(id);
        return RestResponse.of(companyDto, HttpStatus.OK);
    }

    @PostMapping
    public RestResponse save(@RequestBody Company company) {
        CompanyDto companyDto = companyService.saveCompany(company);
        return RestResponse.of(companyDto, HttpStatus.CREATED);
    }

    @PutMapping
    public RestResponse update(@RequestBody Company company) {
        CompanyDto companyDto = companyService.updateEmployee(company);
        return RestResponse.of(companyDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public RestResponse delete(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return RestResponse.of(null,HttpStatus.OK);
    }
}
