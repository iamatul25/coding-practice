package com.stream;

import com.code.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("=== METHOD 1: Stream from Collection ===");
        // TODO: Create a stream from a List of employees
        List<Employee> employees = Arrays.asList(new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32),
                                                new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28),
                                                new Employee("Amit Patel", "Delhi", "IT", 85000, 35));

        // Create stream and print employee names
        employees.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("\n=== METHOD 2: Stream.of() ===");
        // TODO: Create a stream using Stream.of()
        // Create stream of numbers: 10, 20, 30, 40, 50
        // Print each number multiplied by 2
        Stream.of(10, 20, 30, 40, 50).map(n -> n * 2).forEach(System.out::println);


        System.out.println("\n=== METHOD 3: Stream from Array ===");
        // TODO: Create stream from array
        String[] cities = {"Mumbai", "Delhi", "Bangalore", "Chennai", "Pune"};
        Arrays.stream(cities).map(String::toUpperCase).forEach(System.out::println);
        // Print cities in uppercase


        System.out.println("\n=== METHOD 4: Stream.iterate() ===");
        // TODO: Generate first 10 even numbers using Stream.iterate()
        // Starting from 2, increment by 2
        Stream.iterate(2, n -> n + 2).limit(10).forEach(System.out::println);


        System.out.println("\n=== METHOD 5: Stream.generate() ===");
        // TODO: Generate 5 random numbers between 1-100
        Random random = new Random();
        Stream.generate(() -> random.nextInt(100) + 1).limit(5).forEach(System.out::println);


        System.out.println("\n=== METHOD 6: IntStream, LongStream, DoubleStream ===");
        // TODO: Create IntStream from 1 to 10
        // Calculate sum of all numbers
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum = " + sum);


        System.out.println("\n=== METHOD 7: Stream from String ===");
        // TODO: Create stream from characters of a string
        String text = "STREAMS";
        // Print each character
        text.chars().mapToObj(c -> (char) c).forEach(System.out::println);


        System.out.println("\n=== METHOD 8: Empty Stream ===");
        // TODO: Create an empty stream
        // Check if stream is empty
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Is empty stream empty? " + (emptyStream.findAny().isEmpty()));


        System.out.println("\n=== METHOD 9: Stream.builder() ===");
        // TODO: Use Stream.Builder to create a stream
        // Add elements: "Java", "Python", "JavaScript", "C++"
        // Print in sorted order
        Stream<String> languageStream = Stream.<String>builder().add("Java").add("Python").add("JavaScript").add("C++").build();

        languageStream.sorted().forEach(System.out::println);
    }
}
