package com.example.crud.service;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees() throws RecordNotFoundException;

    public Employee getEmployee(Long employeeId) throws RecordNotFoundException;

    public Employee insertEmployee(Employee employee);

    public void deleteEmployee(Long employeeId);

}
