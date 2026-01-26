package com.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32));
        employees.add(new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28));
        employees.add(new Employee("Amit Patel", "Delhi", "IT", 85000, 35));
        employees.add(new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30));
        employees.add(new Employee("Vikram Singh", "Pune", "IT", 95000, 38));
        employees.add(new Employee("Ananya Iyer", "Chennai", "Marketing", 60000, 26));
        employees.add(new Employee("Rahul Verma", "Mumbai", "Finance", 80000, 33));
        employees.add(new Employee("Neha Gupta", "Bangalore", "HR", 55000, 25));
        employees.add(new Employee("Karan Malhotra", "Delhi", "Marketing", 72000, 29));
        employees.add(new Employee("Divya Nair", "Hyderabad", "IT", 88000, 31));

        List<Employee> sortedBySalary = new ArrayList<>(employees);
        //sorting by ascending salary
        sortedBySalary.sort(Comparator.comparing(Employee::getSalary));
        System.out.println("Employees sorted by ascending salary");
        sortedBySalary.forEach(e->System.out.println(e.getName()+"-"+e.getSalary()));
        System.out.println("-----------------------------");
        //sorting by descending salary
        System.out.println("Employees sorted by descending salary");
        sortedBySalary.sort(Comparator.comparing(Employee::getSalary).reversed());
        sortedBySalary.forEach(e->System.out.println(e.getName()+"-"+e.getSalary()));
        System.out.println("-----------------------------");
    }
}
