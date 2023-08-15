package com.example.demo.service;

import com.example.demo.dto.EmployeeRequestDto;
import com.example.demo.dto.EmployeeResponseDto;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
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
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public List<EmployeeResponseDto> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        List<EmployeeResponseDto> employeeResponseDtoList = getEmployeeDtoList(employeeList);

        return employeeResponseDtoList;
    }

    private List<EmployeeResponseDto> getEmployeeDtoList(List<Employee> employeeList) {
        return employeeList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private EmployeeResponseDto convertEntityToDto(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setGender(employee.getGender());
        employeeResponseDto.setCompanyName(employee.getCompany().getName());
        return employeeResponseDto;
    }

    public EmployeeResponseDto findById(Long employeeId) {
        Employee employee = getEmployee(employeeId);

        EmployeeResponseDto employeeResponseDto = convertEntityToDto(employee);
        return employeeResponseDto;
    }

    private Employee getEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        Employee employee = employeeOptional.orElseThrow(() -> new NotFoundException(ErrorMessage.EMPLOYEE_NOT_FOUND));
        return employee;
    }

    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {

        Company company = findCompanyById(employeeRequestDto.getCompanyId());

        Employee employee = createEmployee(employeeRequestDto, company);

        EmployeeResponseDto employeeResponseDto = convertEntityToDto(employee);
        return employeeResponseDto;
    }

    private Employee createEmployee(EmployeeRequestDto employeeRequestDto, Company company) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setGender(employeeRequestDto.getGender());
        employee.setCompany(company);
        employee = employeeRepository.save(employee);
        return employee;
    }

    private Company findCompanyById(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        return companyOptional.orElseThrow(() -> new NotFoundException(ErrorMessage.COMPANY_NOT_FOUND));
    }

    public void deleteEmployee(Long employeeId) {
        checkIsExistEmployee(employeeId);

        employeeRepository.deleteById(employeeId);
    }

    public EmployeeResponseDto update(EmployeeRequestDto employeeRequestDto) {

        Company company = findCompanyById(employeeRequestDto.getCompanyId());

        Employee employee = updateEmployee(employeeRequestDto, company);

        EmployeeResponseDto employeeResponseDto = convertEntityToDto(employee);
        return employeeResponseDto;
    }

    private Employee updateEmployee(EmployeeRequestDto employeeRequestDto, Company company) {
        Employee employee = getEmployee(employeeRequestDto.getId());
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setGender(employeeRequestDto.getGender());
        employee.setCompany(company);
        employee = employeeRepository.save(employee);
        return employee;
    }

    private void checkIsExistEmployee(Long employeeId) {
        boolean existsById = employeeRepository.existsById(employeeId);

        if (!existsById) {
            throw new NotFoundException(ErrorMessage.EMPLOYEE_NOT_FOUND);
        }
    }
}
