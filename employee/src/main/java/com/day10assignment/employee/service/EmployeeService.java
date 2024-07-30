package com.day10assignment.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.day10assignment.employee.exception.InvalidDataException;
import com.day10assignment.employee.model.Employee;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) throws InvalidDataException {
        if (employee.getEmployeeId() == 0 || employee.getFirstName() == null ||
                employee.getLastName() == null || employee.getPosition() == null ||
                employee.getSalary() == 0.0) {
            throw new InvalidDataException("Invalid input given! Kindly check your input.");
        }
        employees.add(employee);
    }
}
