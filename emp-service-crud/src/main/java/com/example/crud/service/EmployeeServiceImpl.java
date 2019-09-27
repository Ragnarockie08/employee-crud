package com.example.crud.service;


import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() throws RecordNotFoundException {

        List<Employee> employees = employeeRepository.findAll();

        if (isEmpty(employees)) {
            throw new RecordNotFoundException("No records found");
        }
        return employees;
    }

    @Override
    public Employee getEmployee(Long employeeId) throws RecordNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent()) {
            throw new RecordNotFoundException("No record found for id: " + employeeId);
        }
        return employee.get();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);

        return emp;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
