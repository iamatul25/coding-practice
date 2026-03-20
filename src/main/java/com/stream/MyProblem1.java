package com.stream;

import com.code.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyProblem1 {
    public static void main(String[] args) {

        // employees by department
        List<Employee> employees = Arrays.asList(
                new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32),
                new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28),
                new Employee("Amit Patel", "Delhi", "IT", 85000, 35),
                new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30),
                new Employee("Vikram Singh", "Pune", "IT", 95000, 38),
                new Employee("Ananya Iyer", "Chennai", "Marketing", 60000, 26),
                new Employee("Rahul Verma", "Mumbai", "Finance", 80000, 33),
                new Employee("Neha Gupta", "Bangalore", "HR", 55000, 25),
                new Employee("Karan Malhotra", "Delhi", "Marketing", 72000, 29),
                new Employee("Divya Nair", "Hyderabad", "IT", 88000, 31));

        Map<String, List<String>> empByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        empByDept.forEach((dept, empName)->System.out.println(empName+" works in "+dept));

    }
}
