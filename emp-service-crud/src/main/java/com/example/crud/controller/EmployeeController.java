package com.example.crud.controller;

import com.example.crud.exception.RecordNotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() throws RecordNotFoundException {
        List<Employee> result = employeeService.getAllEmployees();

        return new ResponseEntity<List<Employee>>(result, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") @Valid @NotNull Long employeeId) throws RecordNotFoundException {
        Employee entity = employeeService.getEmployee(employeeId);
        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody @NotNull Employee employee) {
        Employee entity = employeeService.insertEmployee(employee);
        return new ResponseEntity<Employee>(employee, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(name = "id") @Valid @NotNull Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
