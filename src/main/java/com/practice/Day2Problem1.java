package com.practice;

import com.code.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Day2Problem1 {
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

        // TODO: Task 1 - Create a Predicate to filter employees with salary > 70000
        Predicate<Employee> highSalary = emp-> emp.getSalary()>70000;
        System.out.println("Task 1: Employees with salary > 70000");
        filterAndPrint(employees, highSalary);
        System.out.println("--------------------------");
        employees.stream().filter(e->e.getSalary()>70000).sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).
                forEach(e->System.out.println(e.getName()+" salary is "+ e.getSalary()));
        System.out.println("End of Task 1");


        // TODO: Task 2 - Create a Predicate to filter employees in IT department
        Predicate<Employee> itDepartment = emp->emp.getDepartment().equalsIgnoreCase("IT");
        System.out.println("\nTask 2: Employees in IT department");
        filterAndPrint(employees, itDepartment);
        System.out.println("--------------------------");
        employees.stream().filter(itDepartment).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" department is "+e.getDepartment()));
        System.out.println("End of Task 2");


        // TODO: Task 3 - Create a Predicate to filter employees aged between 25 and 30 (inclusive)
        Predicate<Employee> youngEmployees = e->e.getAge() >= 25 && e.getAge() <= 30;
        System.out.println("\nTask 3: Employees aged 25-30");
        filterAndPrint(employees, youngEmployees);
        System.out.println("--------------------------");
        employees.stream().filter(youngEmployees).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" age is "+e.getAge()));
        System.out.println("End of Task 3");


        // TODO: Task 4 - Combine Predicates using AND
        // Filter employees in IT department AND salary > 80000
        Predicate<Employee> itAndHighSalary = e->e.getDepartment().equalsIgnoreCase("IT") && e.getSalary()>80000;
        System.out.println("\nTask 4: IT employees with salary > 80000");
        filterAndPrint(employees, itAndHighSalary);
        System.out.println("--------------------------");
        employees.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT") && e.getSalary()>80000).sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).
                forEach(e->System.out.println(e.getName()+" age is "+e.getAge()+" and salary is "+e.getSalary()));
        System.out.println("End of Task 4");



        // TODO: Task 5 - Combine Predicates using OR
        // Filter employees in Mumbai OR Bangalore
        Predicate<Employee> mumbaiOrBangalore = e->e.getCity().equalsIgnoreCase("Mumbai") || e.getCity().equalsIgnoreCase("Bangalore");
        System.out.println("\nTask 5: Employees in Mumbai OR Bangalore");
        filterAndPrint(employees, mumbaiOrBangalore);
        System.out.println("--------------------------");
        employees.stream().filter(mumbaiOrBangalore).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" lives in "+e.getCity()));
        System.out.println("End of Task 5");


        // TODO: Task 6 - Use Predicate.negate()
        // Filter employees NOT in IT department
        Predicate<Employee> notIT = itDepartment.negate();
        System.out.println("\nTask 6: Employees NOT in IT");
        filterAndPrint(employees, notIT);
        System.out.println("--------------------------");
        employees.stream().filter(itDepartment.negate()).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" department is "+e.getDepartment()));
        System.out.println("End of Task 6");


        // TODO: Task 7 - Complex condition
        // (IT OR Finance) AND (salary > 75000) AND (age < 35)
        Predicate<Employee> itOrFinance = e -> "IT".equalsIgnoreCase(e.getDepartment()) || "Finance".equalsIgnoreCase(e.getDepartment());
        Predicate<Employee> empSalary = e -> e.getSalary() > 75000;
        Predicate<Employee> empAge = e -> e.getAge() < 35;
        Predicate<Employee> complexCondition = itOrFinance.and(empSalary).and(empAge);
        System.out.println("\nTask 7: (IT OR Finance) AND (salary > 75000) AND (age < 35)");
        filterAndPrint(employees, complexCondition);
        System.out.println("--------------------------");
        employees.stream().filter(itOrFinance.and(empSalary).and(empAge)).sorted(Comparator.comparing(Employee::getName)).
                forEach(e->System.out.println(e.getName()+" age is "+e.getAge()+" and department is "+e.getDepartment()));
        System.out.println("End of Task 7");


        // TODO: BONUS - Create a method that accepts multiple Predicates and combines them with AND
        System.out.println("\nBONUS: Multiple conditions using method");
        List<Employee> filtered = filterByMultipleConditions(employees,
                e -> e.getSalary() > 65000,
                e -> e.getAge() < 33,
                e -> e.getCity().startsWith("B") || e.getCity().startsWith("M")
        );
        System.out.println("--------------------------");
        filtered.forEach(e -> System.out.println(e.getName() + " - " + e.getCity() + " - " + e.getSalary()));
        System.out.println("End of Bonus Task");
    }

    // Helper method to filter and print
    public static void filterAndPrint(List<Employee> employees, Predicate<Employee> predicate) {
        employees.stream()
                .filter(predicate)
                .forEach(e -> System.out.println(e.getName() + " - " + e.getDepartment() + " - " + e.getSalary()));
    }

    // TODO: BONUS - Implement this method
    public static List<Employee> filterByMultipleConditions(
            List<Employee> employees,
            Predicate<Employee> salary,
            Predicate<Employee> age,
            Predicate<Employee> city) {
        return employees.stream().filter(salary.and(age).and(city)).toList();

    }

//    @SafeVarargs
//    public static List<Employee> filterByMultipleConditions(
//            List<Employee> employees, Predicate<Employee>... predicates) {
//        return employees.stream().filter(salary.and(age).and(city)).toList();
//
//    }
}
