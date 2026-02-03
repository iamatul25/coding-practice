package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class LambdaTask {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Task 1: Runnable ===");
        // TODO: Convert this Runnable to lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1 Thread is running: " + Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(100); // Wait for thread to complete

        //lambda implementation of runnable
        Runnable r2 = () -> System.out.println("r2 Thread is running: " + Thread.currentThread().getName());
        Thread t2 = new Thread(r2);
        t2.start();
        Thread.sleep(100);

        System.out.println("\n=== Task 2: Comparator ===");
        // TODO: Convert this Comparator to lambda
        List<String> names = Arrays.asList("Rajesh", "Priya", "Amit", "Ananya", "Vikram");
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        names.sort(lengthComparator);
        System.out.println("Sorted by length: " + names);
        names.sort(Comparator.comparing(String::length));

        System.out.println("\n=== Task 3: Callable ===");
        // TODO: Convert this Callable to lambda
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42 * 2;
            }
        };
        System.out.println("Callable result: " + callable.call());
        Callable<Integer> c = () -> 52 * 2;
        System.out.println("Callable result: " + c.call());

        MyInterface m = (a, b) -> a * b;
        System.out.println(m.doSomething(3, 4));

        // TODO: Convert this to lambda
        StringProcessor processor = new StringProcessor() {
            @Override
            public String process(String str) {
                return str.toUpperCase() + "!";
            }
        };
        System.out.println(processor.process("hello"));

//        StringProcessor sp = String::toUpperCase;
        StringProcessor sp = (s) -> s.toUpperCase();
        System.out.println(sp.process("hello world"));


        System.out.println("\n=== Task 5: Employee Filter ===");
        List<Employee> employees = Arrays.asList(
                new Employee("Rajesh", "Mumbai", "IT", 75000, 32),
                new Employee("Priya", "Bangalore", "HR", 65000, 28),
                new Employee("Amit", "Delhi", "IT", 85000, 35)
        );

        // TODO: Convert this to lambda
        EmployeeFilter highSalaryFilter = new EmployeeFilter() {
            @Override
            public boolean test(Employee emp) {
                return emp.getSalary() > 70000;
            }
        };

        System.out.println("High salary employees:");
        for (Employee emp : employees) {
            if (highSalaryFilter.test(emp)) {
                System.out.println(emp.getName() + " - " + emp.getSalary());
            }
        }
        EmployeeFilter employeeFilter = (e) -> e.getSalary() > 70000;
        for (Employee emp : employees) {
            if (employeeFilter.test(emp)) {
                System.out.println(emp.getName() + " - " + emp.getSalary());
            }

        }
        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee emp : employees) {
            if (highSalaryFilter.test(emp)) {
                filteredEmployees.add(emp);
            }
        }
        filteredEmployees.sort(Comparator.comparing(Employee::getSalary));
        for (Employee emp : filteredEmployees) {
            System.out.println(emp.getName() + " - " + emp.getSalary());
        }
        System.out.println("-----------------------------");
        employees.stream().filter(emp->emp.getSalary()>70000).sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).
                forEach(emp->System.out.println(emp.getName()+" salary is - "+emp.getSalary()));
    }
}
