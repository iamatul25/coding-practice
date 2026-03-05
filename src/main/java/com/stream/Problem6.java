package com.stream;

import com.code.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem6 {
     public static void main(String[] args) {
            List<Employee> employees = Arrays.asList(
                    new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32),
                    new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28),
                    new Employee("Amit Patel", "Delhi", "IT", 85000, 35),
                    new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30),
                    new Employee("Vikram Singh", "Pune", "IT", 95000, 38)
            );

            System.out.println("=== PEEK FOR DEBUGGING ===");

            // TODO: Task 1 - Debug: See elements at each stage
            System.out.println("\n1. Debug stream pipeline:");
            // Pipeline: filter salary > 70000, map to names, sort
            // Use peek() after each operation to see what's happening
            List<String> empNames = employees.stream().filter(e->e.getSalary()>70000).
                                    peek(e -> System.out.println("After filter: " + e)).
                                    map(Employee::getName).
                                    peek(name -> System.out.println("After map: " + name)).
                                    sorted().
                                    peek(name -> System.out.println("After sort: " + name)).
                                    toList();
            System.out.println(empNames);


            // TODO: Task 2 - Count elements at each stage
            System.out.println("\n2. Count elements after each operation:");
            // Use peek with counter to see how many elements pass each stage
            AtomicInteger counter = new AtomicInteger();

            employees.stream()
                    .filter(e -> e.getSalary() > 70000)
                    .peek(e -> System.out.println("Pass filter #" + counter.incrementAndGet()))
                    .map(Employee::getName)
                    .toList();


            // TODO: Task 3 - Monitor filtering
            System.out.println("\n3. Monitor filtering process:");
            // Show which employees pass and fail the filter
            employees.stream()
                    .peek(e -> System.out.println("Checking: " + e.getName()))
                    .filter(e -> {
                           boolean pass = e.getSalary() > 70000;
                           System.out.println(e.getName() + (pass ? " PASSED" : " FAILED"));
                           return pass;
                    })
                    .forEach(e -> System.out.println("Selected: " + e.getName()));


            System.out.println("\n\n=== PEEK FOR SIDE EFFECTS ===");

            // TODO: Task 4 - Log processing
            System.out.println("\n4. Log each employee being processed:");
            // Use peek to log before processing
            employees.stream()
                    .peek(e -> System.out.println("Processing: " + e.getName()))
                    .map(Employee::getName)
                    .forEach(System.out::println);


            // TODO: Task 5 - Modify objects (not recommended, but possible)
            System.out.println("\n5. Give 10% bonus using peek:");
            // Use peek to modify salaries
            List<Employee> employeesCopy = new ArrayList<>();
            employees.forEach(e -> employeesCopy.add(
                    new Employee(e.getName(), e.getCity(), e.getDepartment(), e.getSalary(), e.getAge())
            ));


            // TODO: Task 6 - Multiple peek operations
            System.out.println("\n6. Multiple peek operations in pipeline:");
            // peek after filter, peek after map, peek after sorted
            employees.stream()
                    .filter(e -> e.getSalary() > 70000)
                    .peek(e -> System.out.println("After filter: " + e.getName()))
                    .map(Employee::getName)
                    .peek(name -> System.out.println("After map: " + name))
                    .sorted()
                    .peek(name -> System.out.println("After sorted: " + name))
                    .toList();


            System.out.println("\n\n=== PEEK VS MAP ===");

            // TODO: Task 7 - Show difference between peek and map
            System.out.println("\n7. Peek vs Map:");
            System.out.println("Using peek (doesn't transform):");
            // Try to "transform" with peek - won't work
            employees.stream()
                    .peek(e -> e.getName().toUpperCase()) // does nothing
                    .forEach(e -> System.out.println(e.getName()));

            System.out.println("\nUsing map (transforms):");
            employees.stream()
                    .map(e -> e.getName().toUpperCase())
                    .forEach(System.out::println);
            // Use map to actually transform


            // BONUS: Task 8 - Complex debugging scenario
            System.out.println("\n8. BONUS - Debug complex pipeline:");
            // Pipeline: filter IT dept, map to salary, filter > 80000, sorted desc
            // Add peek at each stage showing what's happening
            employees.stream()
                    .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                    .peek(e -> System.out.println("After dept filter: " + e))
                    .map(Employee::getSalary)
                    .peek(s -> System.out.println("Mapped salary: " + s))
                    .filter(s -> s > 80000)
                    .peek(s -> System.out.println("After salary filter: " + s))
                    .sorted(Comparator.reverseOrder())
                    .peek(s -> System.out.println("After sort: " + s))
                    .toList();

        }
}
