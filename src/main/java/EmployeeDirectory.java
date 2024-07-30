package main.java;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDirectory {
    private Set<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new HashSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();
        Employee emp1 = new Employee(1, "John Doe", "Engineer");
        Employee emp2 = new Employee(2, "Jane Doe", "Manager");

        directory.addEmployee(emp1);
        directory.addEmployee(emp2);

        System.out.println("Employees added.");

        directory.removeEmployee(emp1);

        System.out.println("Employee removed.");
    }
}
