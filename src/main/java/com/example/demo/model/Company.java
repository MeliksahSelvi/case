package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

@Entity
@Getter
@Setter
@Table(name = "COMPANY")
public class Company {

    @SequenceGenerator(name = "Company", sequenceName = "COMPANY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Company")
    @Column
    @Id
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "PHONE", length = 15)
    private String phone;


}
