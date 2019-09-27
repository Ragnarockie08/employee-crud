package com.example.crud.service;

import com.example.crud.exception.NotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.request.EmployeeSearchRequest;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees() throws NotFoundException;

    public Employee getEmployee(Long employeeId) throws NotFoundException;

    public List<Employee> getEmployeeBySearchPhrase(EmployeeSearchRequest request) throws NotFoundException;

    public Employee insertEmployee(Employee employee);

    public void deleteEmployee(Long employeeId) throws NotFoundException;

}
