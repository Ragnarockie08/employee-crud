package com.example.crud.repository;

import com.example.crud.model.Employee;

import java.util.List;


public interface EmployeeRepositoryCustom {

    public List<Employee> findByParams(final List<String> parameters);
}
