package com.example.demo.controller;

import com.example.demo.dto.EmployeeRequestDto;
import com.example.demo.dto.EmployeeResponseDto;
import com.example.demo.dto.RestResponse;
import com.example.demo.service.EmployeeService;
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
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public RestResponse getEmployees() {
        List<EmployeeResponseDto> employeeResponseDtoList = employeeService.getEmployees();
        return RestResponse.of(employeeResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RestResponse findById(@PathVariable Long id) {
        EmployeeResponseDto employeeResponseDto = employeeService.findById(id);
        return RestResponse.of(employeeResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public RestResponse save(@RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.save(employeeRequestDto);
        return RestResponse.of(employeeResponseDto, HttpStatus.CREATED);
    }

    @PutMapping
    public RestResponse update(@RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.update(employeeRequestDto);
        return RestResponse.of(employeeResponseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public RestResponse delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return RestResponse.of(null,HttpStatus.OK);
    }

}
