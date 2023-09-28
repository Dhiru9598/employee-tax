package com.employee.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.entity.Employee;
import com.employee.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/tax-deduction")
    public ResponseEntity<?> getTaxDeductions() {
	return new ResponseEntity<>(employeeRepository.getTaxDeductionDetail(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
	return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> storeEmployeeDetails(@Valid @RequestBody Employee employee) {
	// Save employee details to the database
	Employee savedEmployee = employeeRepository.save(employee);
	return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
}
