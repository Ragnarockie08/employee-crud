package com.example.crud.repository;


import com.example.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
