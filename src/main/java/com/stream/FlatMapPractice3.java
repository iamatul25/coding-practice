package com.stream;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapPractice3 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(new Student("Rajesh", Arrays.asList("Math", "Science", "English")), new Student("Priya", Arrays.asList("Math", "History", "Geography")), new Student("Amit", Arrays.asList("Science", "Math", "Computer")));

        // Problem 1: Get all subjects (with duplicates)
        // TODO: Use flatMap to get all subjects from all students
        // Expected: [Math, Science, English, Math, History, Geography, Science, Math, Computer]
        List<String> subList = students.stream().flatMap(s -> s.getSubjects().stream()).toList();
        System.out.println(subList);


        // Problem 2: Get unique subjects
        // TODO: Get all unique subjects (use .distinct())
        // Expected: [Math, Science, English, History, Geography, Computer]
        List<String> subUniqList = students.stream().flatMap(s -> s.getSubjects().stream()).distinct().toList();
        System.out.println(subUniqList);


        // Problem 3: Count how many students study "Math"
        // TODO: Get all subjects, filter "Math", count
        // Expected: 3
        Long mathSubCount = students.stream().flatMap(s -> s.getSubjects().stream()).filter(s -> s.equalsIgnoreCase("Math")).count();
        System.out.println(mathSubCount);


        // Problem 4: Get names of students who study "Science"
        // TODO: Filter students who have "Science" in subjects, map to names
        // Hint: Don't use flatMap for this one! Use filter and map only
        List<String> nameSub = students.stream().filter(e -> e.getSubjects().contains("Science")).map(Student::getName).toList();
        System.out.println(nameSub);
    }

    @Getter
    static class Student {
        String name;
        List<String> subjects;

        Student(String name, List<String> subjects) {
            this.name = name;
            this.subjects = subjects;
        }

    }
}

