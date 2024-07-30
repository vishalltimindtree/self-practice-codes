package com.day12session1.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day12session1.employeemanagement.exception.NoSuchEmployeeException;
import com.day12session1.employeemanagement.model.Employee;
import com.day12session1.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) throws NoSuchEmployeeException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchEmployeeException("No employee found with id: " + id));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeById(Long id, Employee employeeDetails) throws NoSuchEmployeeException {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setSalary(employeeDetails.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployeeById(Long id) throws NoSuchEmployeeException {
        Employee emp = getEmployeeById(id);
        employeeRepository.delete(emp);
    }
}