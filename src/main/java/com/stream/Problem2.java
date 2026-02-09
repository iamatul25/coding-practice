package com.stream;

import com.code.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32),
                new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28),
                new Employee("Amit Patel", "Delhi", "IT", 85000, 35),
                new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30),
                new Employee("Vikram Singh", "Pune", "IT", 95000, 38),
                new Employee("Ananya Iyer", "Chennai", "Marketing", 60000, 26),
                new Employee("Rahul Verma", "Mumbai", "Finance", 80000, 33),
                new Employee("Neha Gupta", "Bangalore", "HR", 55000, 25)
        );

        System.out.println("=== FILTER OPERATIONS ===");

        // TODO: Task 1 - Filter employees with salary > 70000
        System.out.println("\n1. Employees with salary > 70000:");
        employees.stream().filter(e->e.getSalary()>70000).sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" salary is - "+e.getSalary()));


        // TODO: Task 2 - Filter employees in IT department
        System.out.println("\n2. IT Department employees:");
        employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" department is - "+e.getDepartment()));


        // TODO: Task 3 - Filter employees aged between 25-30
        System.out.println("\n3. Employees aged 25-30:");
        employees.stream().filter(e -> e.getAge() >= 25 && e.getAge() <= 30).sorted(Comparator.comparing(Employee::getAge)).
                forEach(e->System.out.println(e.getName()+" age is - "+e.getAge()));


        // TODO: Task 4 - Filter employees from Mumbai or Bangalore
        System.out.println("\n4. Employees from Mumbai or Bangalore:");
        employees.stream().filter(e->e.getCity().equalsIgnoreCase("Mumbai") ||e.getCity().equalsIgnoreCase("Bangalore")).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" city is - "+e.getCity()));


        // TODO: Task 5 - Filter IT employees with salary > 80000
        System.out.println("\n5. IT employees with salary > 80000:");
        employees.stream().filter(e->e.getSalary()>80000).sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" salary is - "+e.getSalary()));


        System.out.println("\n\n=== MAP OPERATIONS ===");

        // TODO: Task 6 - Get list of all employee names
        System.out.println("\n6. All employee names:");
        employees.stream().map(Employee::getName).sorted().forEach(System.out::println);


        // TODO: Task 7 - Get list of all departments (with duplicates)
        System.out.println("\n7. All departments:");
        employees.stream().map(Employee::getDepartment).sorted().forEach(System.out::println);
        //without duplicated
        System.out.println("\n7. All departments without duplicates :");
        employees.stream().map(Employee::getDepartment).distinct().sorted().forEach(System.out::println);


        // TODO: Task 8 - Get list of salaries in thousands (75000 -> 75)
        System.out.println("\n8. Salaries in thousands:");
        employees.stream().map(e->e.getSalary()/1000).sorted().forEach(System.out::println);


        // TODO: Task 9 - Create email addresses from names
        // Format: firstname.lastname@company.com (lowercase)
        System.out.println("\n9. Email addresses:");
        employees.stream()
                .map(e -> e.getName().toLowerCase().replace(" ", ".") + "@company.com").forEach(System.out::println);


        // TODO: Task 10 - Get annual CTC (salary * 12)
        System.out.println("\n10. Annual CTCs:");
        employees.stream().map(e->e.getSalary()*12).forEach(System.out::println);


        System.out.println("\n\n=== COMBINED FILTER + MAP ===");

        // TODO: Task 11 - Get names of IT employees with salary > 80000
        System.out.println("\n11. Names of IT employees earning > 80000:");
        employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT") && e.getSalary()>80000).
                forEach(System.out::println);


        // TODO: Task 12 - Get cities of employees aged < 30, in uppercase
        System.out.println("\n12. Cities of young employees (uppercase):");
        employees.stream().filter(e->e.getAge()<30).map(e->e.getCity().toUpperCase()).
                sorted().distinct().forEach(System.out::println);


        // TODO: Task 13 - Get annual CTCs of Finance department employees
        System.out.println("\n13. Annual CTCs of Finance employees:");
        employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("Finance")).map(e->e.getSalary()*12).
                forEach(System.out::println);


        // TODO: BONUS - Chain multiple operations
        // Filter: salary > 65000
        // Map: to uppercase names
        // Filter: names starting with 'A' or 'R'
        System.out.println("\n14. BONUS - Complex chain:");
        employees.stream()
                .filter(e -> e.getSalary() > 65000)
                .map(e -> e.getName().toUpperCase())
                .filter(name -> name.startsWith("A") || name.startsWith("R"))
                .forEach(System.out::println);
    }
}
