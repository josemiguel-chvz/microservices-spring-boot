package com.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll() {
        try {
            List<Employee> employees = employeeService.getAll();
            if (employees.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }

    @PostMapping()
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        try {
            Employee newEmployee = employeeService.createProduct(employee);
            return ResponseEntity.ok(newEmployee);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }
}