package com.example.demo.repository;

import com.example.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author mselvi
 * @Created 15.08.2023
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
