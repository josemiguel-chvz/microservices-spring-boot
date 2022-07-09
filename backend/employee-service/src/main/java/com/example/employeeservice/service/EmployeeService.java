package com.example.employeeservice.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createProduct(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }
}