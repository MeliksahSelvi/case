package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;


    public List<CompanyDto> getCompanies() {
        List<Company> companyList = companyRepository.findAll();

        List<CompanyDto> companyDtoList = getCompanyDtoList(companyList);

        return companyDtoList;
    }

    private List<CompanyDto> getCompanyDtoList(List<Company> companyList) {
        return companyList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }


    private CompanyDto convertEntityToDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setPhone(company.getPhone());
        return companyDto;
    }

    public CompanyDto findById(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        Company company = companyOptional.orElseThrow(() -> new NotFoundException(ErrorMessage.COMPANY_NOT_FOUND));

        CompanyDto companyDto = convertEntityToDto(company);
        return companyDto;
    }

    public CompanyDto saveCompany(Company company) {
        company = companyRepository.save(company);

        CompanyDto companyDto = convertEntityToDto(company);
        return companyDto;
    }

    public void deleteCompany(Long companyId) {
        checkIsExistCompany(companyId);

        companyRepository.deleteById(companyId);
    }

    public CompanyDto updateEmployee(Company company) {
        checkIsExistCompany(company.getId());

        company = companyRepository.save(company);

        CompanyDto companyDto = convertEntityToDto(company);
        return companyDto;
    }

    private void checkIsExistCompany(Long companyId) {
        boolean existsById = companyRepository.existsById(companyId);

        if (!existsById) {
            throw new NotFoundException(ErrorMessage.COMPANY_NOT_FOUND);
        }
    }
}
