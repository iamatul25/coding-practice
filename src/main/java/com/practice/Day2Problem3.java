package com.practice;

import com.code.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Day2Problem3 {
    private static int employeeIdCounter = 1000;
    private static final Logger logger = Logger.getLogger(Day2Problem3.class.getName());

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32));
        employees.add(new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28));
        employees.add(new Employee("Amit Patel", "Delhi", "IT", 85000, 35));

        System.out.println("=== CONSUMER EXAMPLES ===");
        // Task 1 - Create a Consumer to print employee details
        Consumer<Employee> printEmployee = e ->
                System.out.println(e.getName() + " - " + e.getDepartment() + " - ₹" + e.getSalary());

        System.out.println("\nTask 1: Print Employees");
        employees.forEach(printEmployee);


        // Task 2 - Create a Consumer to give 10% salary hike
        Consumer<Employee> giveHike = e -> e.setSalary((int)(e.getSalary() * 1.1));

        System.out.println("\nTask 2: After 10% Hike");
        employees.forEach(giveHike);
        employees.forEach(e -> System.out.println(e.getName() + " - New Salary: ₹" + e.getSalary()));


        // Task 3 - Chain Consumers using andThen()
        // Reset salaries first
        employees.get(0).setSalary(75000);
        employees.get(1).setSalary(65000);
        employees.get(2).setSalary(85000);

        Consumer<Employee> printThenHike = printEmployee.andThen(giveHike);

        System.out.println("\nTask 3: Print then Hike (chained)");
        employees.forEach(printThenHike);
        System.out.println("\nAfter chained operation:");
        employees.forEach(e -> System.out.println(e.getName() + " - ₹" + e.getSalary()));


        // Task 4 - Create multiple Consumers and chain them
        Consumer<Employee> validateSalary = e -> {
            if (e.getSalary() < 50000) {
                System.out.println("⚠️ WARNING: " + e.getName() + " has low salary!");
            }
        };

        Consumer<Employee> logEmployee = e -> {
            System.out.println("[LOG] Processing: " + e.getName());
        };

        Consumer<Employee> complexChain = logEmployee
                .andThen(validateSalary)
                .andThen(printEmployee);

        System.out.println("\nTask 4: Complex Consumer Chain");
        employees.forEach(complexChain);


        System.out.println("\n\n=== SUPPLIER EXAMPLES ===");

        // Task 5 - Create a Supplier to generate random employee
        Supplier<Employee> randomEmployeeSupplier = () -> {
            String[] names = {"Rahul Sharma", "Priya Gupta", "Amit Kumar", "Sneha Reddy", "Vikram Singh"};
            String[] cities = {"Mumbai", "Delhi", "Bangalore", "Pune", "Chennai"};
            String[] departments = {"IT", "HR", "Finance", "Marketing"};

            Random random = new Random();

            String name = names[random.nextInt(names.length)];
            String city = cities[random.nextInt(cities.length)];
            String department = departments[random.nextInt(departments.length)];
            int salary = 50000 + random.nextInt(50000); // 50k to 100k
            int age = 22 + random.nextInt(18); // 22 to 40

            return new Employee(name, city, department, salary, age);
        };

        System.out.println("\nTask 5: Generate 5 Random Employees");
        for (int i = 0; i < 5; i++) {
            Employee emp = randomEmployeeSupplier.get();
            System.out.println(emp);
        }


        // Task 6 - Create a Supplier for unique employee IDs
        Supplier<Integer> idSupplier = () -> ++employeeIdCounter;

        System.out.println("\nTask 6: Generate 10 Unique IDs");
        for (int i = 0; i < 10; i++) {
            System.out.println("ID: " + idSupplier.get());
        }


        // Task 7 - Create a Supplier for current date
        Supplier<String> dateSupplier = () -> LocalDate.now().toString();

        System.out.println("\nTask 7: Current Date");
        System.out.println("Today is: " + dateSupplier.get());


        // BONUS - Create a factory method using Supplier
        System.out.println("\n\n=== BONUS: Employee Factory ===");

        Supplier<Employee> itEmployeeFactory = createEmployeeFactory("IT", 80000, 30);
        Supplier<Employee> hrEmployeeFactory = createEmployeeFactory("HR", 60000, 25);

        System.out.println("IT Employees:");
        for (int i = 0; i < 3; i++) {
            System.out.println(itEmployeeFactory.get());
        }

        System.out.println("\nHR Employees:");
        for (int i = 0; i < 3; i++) {
            System.out.println(hrEmployeeFactory.get());
        }
    }

    // BONUS - Factory method implementation
    public static Supplier<Employee> createEmployeeFactory(
            String department,
            Integer baseSalary,
            Integer baseAge) {

        String[] firstNames = {"Rajesh", "Priya", "Amit", "Sneha", "Vikram", "Ananya", "Rahul", "Neha"};
        String[] lastNames = {"Kumar", "Sharma", "Patel", "Reddy", "Singh", "Iyer", "Verma", "Gupta"};
        String[] cities = {"Mumbai", "Delhi", "Bangalore", "Pune", "Chennai", "Hyderabad"};
        Random random = new Random();

        return () -> {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String name = firstName + " " + lastName;

            String city = cities[random.nextInt(cities.length)];

            // Salary varies ±10000 from base
            int salary = baseSalary + random.nextInt(20001) - 10000;

            // Age varies ±5 from base
            int age = baseAge + random.nextInt(11) - 5;

            return new Employee(name, city, department, salary, age);
        };
    }
}
