package com.stream;

import com.code.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Problem8 {
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

        System.out.println("=== TOLIST AND TOSET ===");

        // Task 1 - Collect employee names to List
        System.out.println("\n1. Employee names (List):");
        // TODO: Collect all names to List
        employees.stream().map(Employee::getName).toList().forEach(System.out::println);


        // Task 2 - Collect unique departments to Set
        System.out.println("\n2. Unique departments (Set):");
        // TODO: Collect unique departments to Set
        Set<String> uniqDept = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println(uniqDept);


        // Task 3 - Collect IT employee names to Set
        System.out.println("\n3. IT employee names (Set):");
        // TODO: Filter IT, map to names, collect to Set
        Set<String> itEmpNames = employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).
                map(Employee::getName).collect(Collectors.toSet());
        System.out.println(itEmpNames);


        System.out.println("\n\n=== JOINING ===");

        // Task 4 - Join all names with comma
        System.out.println("\n4. All names (comma-separated):");
        // TODO: Use Collectors.joining(", ")
        String allNames = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(allNames);


        // Task 5 - Join IT employee names with " | " separator
        System.out.println("\n5. IT employees (pipe-separated):");
        // TODO: Filter IT, join with " | "
        String itNames = employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).map(Employee::getName).
                collect(Collectors.joining(" | "));
        System.out.println(itNames);


        // Task 6 - Join with prefix and suffix
        System.out.println("\n6. Names with brackets:");
        // TODO: Use Collectors.joining(", ", "[", "]")
        String bracketNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(bracketNames);


        System.out.println("\n\n=== COUNTING ===");

        // Task 7 - Count total employees
        System.out.println("\n7. Total employees:");
        // TODO: Use Collectors.counting()
        long totalEmployees = employees.stream().count();
        System.out.println(totalEmployees);


        // Task 8 - Count IT employees
        System.out.println("\n8. IT employees count:");
        // TODO: Filter IT, count
        long itEmpCount = employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).count();
        System.out.println(itEmpCount);


        // Task 9 - Count employees with salary > 70000
        System.out.println("\n9. High earners count:");
        // TODO: Filter salary > 70000, count
        var highSalCount = employees.stream().filter(e -> e.getSalary() > 70000).count();
        System.out.println(highSalCount);


        System.out.println("\n\n=== SUMMING ===");

        // Task 10 - Total salary expense
        System.out.println("\n10. Total salary expense:");
        // TODO: Use Collectors.summingInt(Employee::getSalary)
        var totalSalary = employees.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println(totalSalary);


        // Task 11 - Total salary for IT department
        System.out.println("\n11. IT department total salary:");
        // TODO: Filter IT, sum salaries
        var itEmpSalSum = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("IT")).mapToInt(Employee::getSalary).sum();
        System.out.println(itEmpSalSum);


        // Task 12 - Total age of all employees
        System.out.println("\n12. Total age:");
        // TODO: Sum all ages
        var totalAge = employees.stream().mapToInt(Employee::getAge).sum();
        System.out.println(totalAge);



        System.out.println("\n\n=== AVERAGING ===");

        // Task 13 - Average salary
        System.out.println("\n13. Average salary:");
        // TODO: Use Collectors.averagingDouble(Employee::getSalary)
        var avgSal = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
//        var avgSal = employees.stream().mapToInt(Employee::getSalary).average();
        System.out.println(avgSal);


        // Task 14 - Average age
        System.out.println("\n14. Average age:");
        // TODO: Average age
        var avgAge = employees.stream().mapToInt(Employee::getAge).average();
        System.out.println(avgAge);

        // Task 15 - Average salary of IT department
        System.out.println("\n15. IT department average salary:");
        // TODO: Filter IT, average salary
        var itEmpAvgSal = employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(itEmpAvgSal);


        System.out.println("\n\n=== MAX AND MIN ===");

        // Task 16 - Highest paid employee
        System.out.println("\n16. Highest paid employee:");
        // TODO: Use Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        Optional<Employee> highestPaid = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println(highestPaid.orElse(null));


        // Task 17 - Lowest paid employee
        System.out.println("\n17. Lowest paid employee:");
        // TODO: Use Collectors.minBy
        Optional<Employee> lowestPaid = employees.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)));
        System.out.println(lowestPaid.orElse(null));


        // Task 18 - Oldest employee
        System.out.println("\n18. Oldest employee:");
        // TODO: Use maxBy with age
        Optional<Employee> highestAge = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
        System.out.println(highestAge.orElse(null));


        System.out.println("\n\n=== TOMAP ===");

        // Task 19 - Create Map of name to salary
        System.out.println("\n19. Name to Salary Map:");
        // TODO: Use Collectors.toMap(Employee::getName, Employee::getSalary)
        Map<String, Integer> nameSal = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(nameSal);


        // Task 20 - Create Map of name to department
        System.out.println("\n20. Name to Department Map:");
        // TODO: toMap(name, department)
        Map<String, String> nameDept = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
        System.out.println(nameDept);


        // BONUS: Task 21 - Create Map with duplicate handling
        System.out.println("\n21. BONUS - City to employee count:");
        // TODO: toMap with merge function for duplicates
        Map<String, Integer> cityCount = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getCity,
                        e -> 1,
                        Integer::sum));

        System.out.println(cityCount);

    }
}
