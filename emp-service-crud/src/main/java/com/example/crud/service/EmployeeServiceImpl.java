package com.example.crud.service;


import com.example.crud.exception.NotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.repository.EmployeeRepositoryDaoImpl;
import com.example.crud.request.EmployeeSearchRequest;
import com.example.crud.request.ModifyEmployeeRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRepositoryDaoImpl employeeRepositoryDaoImpl;

    @Override
    public List<Employee> getAllEmployees() throws NotFoundException {

        List<Employee> employees = employeeRepository.findAll();
        log.info("Retrieve all employees={}", employees);
        if (isEmpty(employees)) {
            throw new NotFoundException("No records found");
        }
        return employees;
    }

    @Override
    public Employee getEmployee(Long employeeId) throws NotFoundException {

        log.info("Retrieve employee with id={}", employeeId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent()) {
            throw new NotFoundException("No record found for id: " + employeeId);
        }
        return employee.get();
    }

    @Override
    public List<Employee> getEmployeeBySearchPhrase(EmployeeSearchRequest request) throws NotFoundException {
        if (isEmpty(request.getSearchPhrases())) {
            return employeeRepository.findAll();
        }
        log.info("Search employees with matching phrases={}", request.getSearchPhrases());
        return employeeRepositoryDaoImpl.findByParams(request.getSearchPhrases());
    }

    @Override
    public Employee insertEmployee(ModifyEmployeeRequest request) {

        log.info("Insert/update employee={}", request.getEmployee());
        if (isNull(request.getEmployee())) {
            return null;
        }
        return employeeRepository.save(request.getEmployee());
    }

    @Override
    public void deleteEmployee(Long employeeId) throws NotFoundException{

        log.info("Delete employee with id={}", employeeId);
        try {
            employeeRepository.deleteById(employeeId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("No record found for id=" + employeeId);
        }
    }
}
