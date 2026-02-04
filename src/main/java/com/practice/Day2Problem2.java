package com.practice;

import com.code.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Day2Problem2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32));
        employees.add(new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28));
        employees.add(new Employee("Amit Patel", "Delhi", "IT", 85000, 35));
        employees.add(new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30));
        employees.add(new Employee("Vikram Singh", "Pune", "IT", 95000, 38));

        // TODO: Task 1 - Extract employee names using Function
        Function<Employee, String> getName = Employee::getName;
        System.out.println("Task 1: Employee Names");
        employees.stream().map(getName).forEach(System.out::println);

        // TODO: Task 2 - Calculate annual salary (monthly * 12) using Function
        Function<Employee, Integer> getAnnualSalary = e -> e.getSalary() * 12;
        System.out.println("\nTask 2: Annual Salaries");
        employees.forEach(e -> System.out.println(e.getName() + " - Annual: ₹" + getAnnualSalary.apply(e))
        );

        // TODO: Task 3 - Create email from name (lowercase, replace space with .)
        // Example: "Rajesh Kumar" -> "rajesh.kumar@company.com"
        Function<Employee, String> createEmail = emp -> emp.getName().toLowerCase().
                replace(" ", ".") + "@company.com";
        System.out.println("\nTask 3: Employee Emails");
        employees.forEach(e -> System.out.println(e.getName() + " - " + createEmail.apply(e))
        );

        // TODO: Task 4 - Create a summary string
        // Format: "Name: X, Dept: Y, Salary: Z"
        Function<Employee, String> createSummary = e -> "Name: " + e.getName() + ", Dept: " + e.getDepartment() + ", Salary: " + e.getSalary();
        System.out.println("\nTask 4: Employee Summaries");
        employees.stream()
                .map(createSummary)
                .forEach(System.out::println);

        // TODO: Task 5 - Chain Functions using andThen()
        // First get salary, then calculate 10% bonus
        Function<Employee, Integer> getSalary = Employee::getSalary;
        Function<Integer, Integer> calculateBonus = salary -> salary / 10;
        Function<Employee, Integer> getSalaryWithBonus = getSalary.andThen(calculateBonus);
        ;

        System.out.println("\nTask 5: Salary with 10% Bonus");
        employees.forEach(e -> System.out.println(e.getName() + " - Bonus: ₹" + getSalaryWithBonus.apply(e)));
        System.out.println("--------------------------------");
        employees.stream().map(Employee::getSalary).map(salary -> salary / 10).forEach(System.out::println);

        // give 30% increment to employees whoe monthly salary is less than 80000
        employees.stream().filter(e -> e.getSalary() <= 80000).
                forEach(e -> e.setSalary(e.getSalary() + (int) (e.getSalary() * 0.30)));

        List<Employee> updatedSalaryEmp = employees.stream().filter(e -> e.getSalary() <= 80000)
                .peek(e -> e.setSalary(e.getSalary() + (int) (e.getSalary() * 0.30))).toList();


        List<Employee> updatedEmployees =
                employees.stream()
                        .map(e -> {
                            if (e.getSalary() <= 80000) {
                                return new Employee(
                                        e.getName(),
                                        e.getCity(),
                                        e.getDepartment(),
                                        e.getSalary() + (int) (e.getSalary() * 0.30),
                                        e.getAge()
                                );
                            }
                            return e;
                        })
                        .toList();


        // TODO: Task 6 - Chain Functions using compose()
        // Create a function that takes a salary and returns employee grade
        Function<Integer, String> salaryToGrade = salary -> {
            if (salary >= 90000) return "A";
            if (salary >= 75000) return "B";
            if (salary >= 60000) return "C";
            return "D";
        };

        Function<Employee, String> getEmployeeGrade = salaryToGrade.compose(getSalary);
        System.out.println("\nTask 6: Employee Grades");
        employees.stream().sorted(Comparator.comparing(Employee::getName))
                .forEach(e ->
                        System.out.println(
                                e.getName() + " - Grade: " + getEmployeeGrade.apply(e)
                        )
                );
    }
}
