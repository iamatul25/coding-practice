package com.stream;

import com.code.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
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
                new Employee("Divya Nair", "Hyderabad", "IT", 88000, 31)
        );

        System.out.println("=== DISTINCT OPERATIONS ===");

        // TODO: Task 1 - Get unique departments
        System.out.println("\n1. Unique departments:");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);


        // TODO: Task 2 - Get unique cities
        System.out.println("\n2. Unique cities:");
        employees.stream().map(Employee::getCity).distinct().forEach(System.out::println);


        // TODO: Task 3 - Get unique salary ranges (in 10k brackets)
        // Example: 55000 -> 50000, 75000 -> 70000
        System.out.println("\n3. Unique salary ranges (10K brackets):");
        employees.stream()
                .map(e -> (e.getSalary() / 10000) * 10000)
                .distinct()
                .forEach(System.out::println);


        System.out.println("\n\n=== SORTED OPERATIONS ===");

        // TODO: Task 4 - Sort employees by name (alphabetically)
        System.out.println("\n4. Employees sorted by name:");
        employees.stream().map(Employee::getName).sorted().forEach(System.out::println);


        // TODO: Task 5 - Sort employees by salary (ascending)
        System.out.println("\n5. Employees sorted by salary (ascending):");
        employees.stream().map(Employee::getSalary).sorted().forEach(System.out::println);


        // TODO: Task 6 - Sort employees by salary (descending)
        System.out.println("\n6. Employees sorted by salary (descending):");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);


        // TODO: Task 7 - Sort employees by age, then by salary
        System.out.println("\n7. Employees sorted by age, then salary:");
        employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getAge)).forEach(System.out::println);


        // TODO: Task 8 - Sort departments alphabetically (unique)
        System.out.println("\n8. Departments sorted alphabetically:");
        //below one will sort employees department will still be repeated
        employees.stream().sorted(Comparator.comparing(Employee::getDepartment)).distinct().forEach(System.out::println);

        //below one is correct
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n\n=== COMBINED OPERATIONS ===");

        // TODO: Task 9 - Get unique cities, sorted alphabetically
        System.out.println("\n9. Unique cities (sorted):");
        employees.stream().map(Employee::getCity).sorted().distinct().forEach(System.out::println);


        // TODO: Task 10 - Get unique departments, sort by name, convert to uppercase
        System.out.println("\n10. Unique departments (sorted, uppercase):");
        employees.stream().map(e->e.getDepartment().toUpperCase()).distinct().sorted().forEach(System.out::println);

        //below is more optimised because it first removes duplicates then sort fewer items
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        // TODO: Task 11 - Get employees from IT, sort by salary desc, get top 3
        System.out.println("\n11. Top 3 IT employees by salary:");
        employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).
                sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);


        // TODO: Task 12 - Get unique ages, sorted ascending
        System.out.println("\n12. Unique ages (sorted):");
        employees.stream().map(Employee::getAge).distinct().sorted().forEach(System.out::println);


        // TODO: BONUS - Complex operation
        // Filter: salary > 65000
        // Map: get departments
        // Distinct: unique departments
        // Sorted: alphabetically
        System.out.println("\n13. BONUS - Departments of high earners (unique, sorted):");
        employees.stream().filter(e->e.getSalary()>65000).map(Employee::getDepartment).
                distinct().sorted().forEach(System.out::println);

    }
}
