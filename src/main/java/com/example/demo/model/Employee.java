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
@Table(name = "EMPLOYEE")
public class Employee {

    @SequenceGenerator(name = "Employee", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Employee")
    @Column
    @Id
    private Long id;

    @Column(name = "FIRST_NAME", length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "GENDER", length = 10)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY", foreignKey = @ForeignKey(name = "FK_EMPLOYEE_COMPANY"))
    private Company company;
}
