package com.stream;

import com.code.Employee;

import java.util.*;
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

        //highest paid employee per department
        Map<String, Optional<Employee>> highSalByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        highSalByDept.forEach((dept, emp)-> System.out.println(dept+" dept highest salary is "+emp.map(Employee::getSalary).orElse(0)));

        //Flatten a list of lists and find distinct sorted elements
        List<List<Integer>> nested = List.of(List.of(3, 1, 4,7),
                                            List.of(1, 5, 8, 8, 9),
                                            List.of(2, 6, 5, 7, 6));
        List<Integer> numList = nested.stream().flatMap(Collection::stream).distinct().sorted().toList();
        numList.forEach(System.out::println);


    }
}
