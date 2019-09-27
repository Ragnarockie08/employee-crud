package com.example.crud;

import com.example.crud.exception.NotFoundException;
import com.example.crud.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees() throws NotFoundException;

    public Employee getEmployee(Long employeeId) throws NotFoundException;

    public Employee insertEmployee(Employee employee);

    public void deleteEmployee(Long employeeId) throws NotFoundException;

}
