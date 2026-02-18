package com.stream;

import com.code.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Problem4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32), new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28), new Employee("Amit Patel", "Delhi", "IT", 85000, 35), new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30), new Employee("Vikram Singh", "Pune", "IT", 95000, 38), new Employee("Ananya Iyer", "Chennai", "Marketing", 60000, 26));

        System.out.println("=== FOREACH OPERATIONS ===");

        // TODO: Task 1 - Print all employee names
        System.out.println("\n1. All employee names:");
        employees.forEach(e -> System.out.println(e.getName()));


        // TODO: Task 2 - Print name and salary of IT employees
        System.out.println("\n2. IT employees (name and salary):");
        employees.forEach(e -> System.out.println(e.getName() + " salary is " + e.getSalary()));


        // TODO: Task 3 - Print employees with formatted output
        // Format: "Name: X, Dept: Y, Salary: ₹Z"
        System.out.println("\n3. Formatted employee details:");
        employees.forEach(e -> System.out.println(" \"Name: " + e.getName() + ", Dept : " + e.getDepartment() + ", Salary: " + e.getSalary()));


        System.out.println("\n\n=== COLLECT OPERATIONS ===");

        // TODO: Task 4 - Collect all employee names into a List
        System.out.println("\n4. Collect names into List:");
        List<String> empNames = employees.stream().map(Employee::getName).toList();
        System.out.println(empNames);


        // TODO: Task 5 - Collect unique departments into a Set
        System.out.println("\n5. Collect unique departments:");
        Set<String> empDept = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println(empDept);


        // TODO: Task 6 - Collect employees with salary > 70000 into a List
        System.out.println("\n6. High earners (> 70000):");
        employees.stream().filter(e -> e.getSalary() > 70000).forEach(System.out::println);


        // TODO: Task 7 - Collect names into a comma-separated String
        // Use Collectors.joining(", ")
        System.out.println("\n7. Names as comma-separated string:");
        String joinedName = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(joinedName);


        // TODO: Task 8 - Collect employees into a Map (name -> salary)
        System.out.println("\n8. Map of name to salary:");
        Map<String, Integer> nameSalaryMap = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(nameSalaryMap);


        System.out.println("\n\n=== COUNT OPERATIONS ===");

        // TODO: Task 9 - Count total employees
        System.out.println("\n9. Total employees:");
        Integer empCount = employees.size();
        System.out.println(empCount);


        // TODO: Task 10 - Count IT employees
        System.out.println("\n10. IT employees count:");
        Long empItCount = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("IT")).count();
        System.out.println(empItCount);


        // TODO: Task 11 - Count employees with salary > 75000
        System.out.println("\n11. Employees earning > 75000:");
        Long empSalCount = employees.stream().filter(e -> e.getSalary() > 75000).count();
        System.out.println(empSalCount);


        // TODO: Task 12 - Count employees aged < 30
        System.out.println("\n12. Young employees (< 30):");
        Long empAgeCount = employees.stream().filter(e -> e.getAge() < 30).count();
        System.out.println(empAgeCount);


        // TODO: Task 13 - Count unique departments
        System.out.println("\n13. Number of unique departments:");
        Long uniqueDeptCount = employees.stream().map(Employee::getDepartment).distinct().count();
        System.out.println(uniqueDeptCount);


        System.out.println("\n\n=== COMBINED OPERATIONS ===");

        // TODO: Task 14 - Get top 3 salaries as a List
        System.out.println("\n14. Top 3 salaries:");
        employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);


        // TODO: Task 15 - Get names of employees from Mumbai, sorted
        System.out.println("\n15. Mumbai employees (sorted by name):");
        employees.stream().filter(e -> e.getCity().equalsIgnoreCase("Mumbai")).map(Employee::getName).sorted().forEach(System.out::println);


        // TODO: Task 16 - Count employees in each city
        // Hint: Use groupingBy with counting()
        System.out.println("\n16. Employee count by city:");
        Map<String, Long> countByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        countByCity.forEach((city, count) -> System.out.println(city + " : " + count));

        // TODO: BONUS - Get department-wise average salary
        // Use Collectors.groupingBy with averagingDouble
        System.out.println("\n17. BONUS - Average salary by department:");
        Map<String, Double> avgSalByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        avgSalByDept.forEach((dept, avgSal) -> System.out.println("Avg salary of " + dept + " department is - " + avgSal));

    }
}
