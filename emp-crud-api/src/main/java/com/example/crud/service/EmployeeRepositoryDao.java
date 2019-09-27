package com.example.crud.service;

import com.example.crud.model.Employee;

import java.util.List;

public interface EmployeeRepositoryDao {

    public List<Employee> findByParams(List<String> parameters);
}
