package com.example.crud.controller;

import com.example.crud.exception.NotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.request.ModifyEmployeeRequest;
import com.example.crud.service.EmployeeService;
import com.example.crud.request.EmployeeSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Employee>> getAllEmployees() throws NotFoundException {
        List<Employee> result = employeeService.getAllEmployees();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") @Valid @NotNull Long employeeId) throws NotFoundException {
        Employee entity = employeeService.getEmployee(employeeId);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/employees/search")
    public ResponseEntity<List<Employee>> gwtEmployeesByParams(@RequestBody @Valid EmployeeSearchRequest request) throws NotFoundException {
        List<Employee> entities = employeeService.getEmployeeBySearchPhrase(request);
        return ResponseEntity.ok(entities);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody @NotNull ModifyEmployeeRequest request) {
        Employee entity = employeeService.insertEmployee(request);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable(name = "id") @Valid @NotNull Long employeeId) throws NotFoundException {
        employeeService.deleteEmployee(employeeId);
    }
}
