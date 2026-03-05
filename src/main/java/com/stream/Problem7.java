package com.stream;

import com.code.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 { public static void main(String[] args) {
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

    System.out.println("=== LIMIT OPERATIONS ===");

    // Task 1 - Get first 5 employees
    System.out.println("\n1. First 5 employees:");
    employees.stream()
            .limit(5)
            .forEach(e -> System.out.println("  " + e.getName()));


    // Task 2 - Get top 3 highest paid employees
    System.out.println("\n2. Top 3 highest paid:");
    employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .limit(3)
            .forEach(e -> System.out.println("  " + e.getName() + " - ₹" + e.getSalary()));


    // Task 3 - Get first 3 IT employees
    System.out.println("\n3. First 3 IT employees:");
    employees.stream()
            .filter(e -> e.getDepartment().equals("IT"))
            .limit(3)
            .forEach(e -> System.out.println("  " + e.getName() + " - " + e.getDepartment()));


    System.out.println("\n\n=== SKIP OPERATIONS ===");

    // Task 4 - Skip first 3 employees, get rest
    System.out.println("\n4. Skip first 3, get rest:");
    employees.stream()
            .skip(3)
            .forEach(e -> System.out.println("  " + e.getName()));


    // Task 5 - Skip first 5, get next 3
    System.out.println("\n5. Skip first 5, get next 3:");
    employees.stream()
            .skip(5)
            .limit(3)
            .forEach(e -> System.out.println("  " + e.getName()));


    System.out.println("\n\n=== PAGINATION ===");

    // Task 6 - Implement pagination - Page 1
    // Page size: 3, Get page 1 (first 3)
    System.out.println("\n6. Page 1 (size 3):");
    int pageSize = 3;
    employees.stream()
            .skip(0)  // Page 1: skip 0
            .limit(pageSize)
            .forEach(e -> System.out.println("  " + e.getName()));


    // Task 7 - Get page 2
    System.out.println("\n7. Page 2 (size 3):");
    employees.stream()
            .skip(3)  // Page 2: skip 3 (pageSize * 1)
            .limit(pageSize)
            .forEach(e -> System.out.println("  " + e.getName()));


    // Task 8 - Get page 3
    System.out.println("\n8. Page 3 (size 3):");
    employees.stream()
            .skip(6)  // Page 3: skip 6 (pageSize * 2)
            .limit(pageSize)
            .forEach(e -> System.out.println("  " + e.getName()));


    // Task 9 - Create a pagination method
    System.out.println("\n9. Using pagination method:");
    List<Employee> page1 = getPage(employees, 1, 3);
    List<Employee> page2 = getPage(employees, 2, 3);
    List<Employee> page3 = getPage(employees, 3, 3);

    System.out.println("Page 1:");
    page1.forEach(e -> System.out.println("  " + e.getName()));

    System.out.println("Page 2:");
    page2.forEach(e -> System.out.println("  " + e.getName()));

    System.out.println("Page 3:");
    page3.forEach(e -> System.out.println("  " + e.getName()));


    System.out.println("\n\n=== COMBINED OPERATIONS ===");

    // Task 10 - Get employees 4-6 sorted by salary
    System.out.println("\n10. Employees 4-6 (sorted by salary):");
    employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary))
            .skip(3)  // Skip first 3
            .limit(3)  // Take next 3 (positions 4, 5, 6)
            .forEach(e -> System.out.println("  " + e.getName() + " - ₹" + e.getSalary()));


    // Task 11 - Top 5 IT employees by salary
    System.out.println("\n11. Top 5 IT employees by salary:");
    employees.stream()
            .filter(e -> e.getDepartment().equals("IT"))
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .limit(5)
            .forEach(e -> System.out.println("  " + e.getName() + " - ₹" + e.getSalary()));


    // Task 12 - Skip lowest 3 salaries, get next 4
    System.out.println("\n12. Skip lowest 3 salaries, get next 4:");
    employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary))  // Sort ascending
            .skip(3)  // Skip lowest 3
            .limit(4)  // Get next 4
            .forEach(e -> System.out.println("  " + e.getName() + " - ₹" + e.getSalary()));


    // BONUS: Task 13 - Implement full pagination utility
    System.out.println("\n13. BONUS - Full pagination utility:");

    // Test different pages
    PageResult<Employee> pageResult1 = paginate(employees, 1, 3);
    System.out.println("\n--- Page 1 ---");
    printPageResult(pageResult1);

    PageResult<Employee> pageResult2 = paginate(employees, 2, 3);
    System.out.println("\n--- Page 2 ---");
    printPageResult(pageResult2);

    PageResult<Employee> pageResult4 = paginate(employees, 4, 3);
    System.out.println("\n--- Page 4 (Last Page) ---");
    printPageResult(pageResult4);

    // Test edge case: page beyond available data
    PageResult<Employee> pageResult10 = paginate(employees, 10, 3);
    System.out.println("\n--- Page 10 (Beyond data) ---");
    printPageResult(pageResult10);
}

    // Task 9 - Implement pagination helper method
    public static <T> List<T> getPage(List<T> list, int pageNumber, int pageSize) {
        // pageNumber starts from 1
        // Formula: skip = (pageNumber - 1) * pageSize

        return list.stream()
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    // BONUS: Task 13 - Implement full pagination utility
    public static <T> PageResult<T> paginate(List<T> list, int pageNumber, int pageSize) {
        // Calculate total pages
        int totalPages = (int) Math.ceil((double) list.size() / pageSize);

        // Get current page data
        List<T> data = list.stream()
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        // Determine hasNext and hasPrevious
        boolean hasNext = pageNumber < totalPages;
        boolean hasPrevious = pageNumber > 1;

        return new PageResult<>(data, pageNumber, totalPages, hasNext, hasPrevious);
    }

    // Helper method to print page result
    private static void printPageResult(PageResult<Employee> pageResult) {
        System.out.println("Current Page: " + pageResult.currentPage);
        System.out.println("Total Pages: " + pageResult.totalPages);
        System.out.println("Has Next: " + pageResult.hasNext);
        System.out.println("Has Previous: " + pageResult.hasPrevious);
        System.out.println("Items on this page: " + pageResult.data.size());
        System.out.println("Data:");
        pageResult.data.forEach(e -> System.out.println("  " + e.getName()));
    }

    // BONUS: PageResult class
    static class PageResult<T> {
        List<T> data;
        int currentPage;
        int totalPages;
        boolean hasNext;
        boolean hasPrevious;

        PageResult(List<T> data, int currentPage, int totalPages, boolean hasNext, boolean hasPrevious) {
            this.data = data;
            this.currentPage = currentPage;
            this.totalPages = totalPages;
            this.hasNext = hasNext;
            this.hasPrevious = hasPrevious;
        }
    }
}
