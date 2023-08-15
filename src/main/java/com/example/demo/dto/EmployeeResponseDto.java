package com.example.demo.dto;

import lombok.Data;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

@Data
public class EmployeeResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String  gender;
    private String companyName;
}
