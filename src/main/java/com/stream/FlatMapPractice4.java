package com.stream;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class FlatMapPractice4 {
    public static void main(String[] args) {

        List<School> schools = Arrays.asList(new School("School A", Arrays.asList(new ClassRoom("Class 1", Arrays.asList("Rajesh", "Priya")),
                new ClassRoom("Class 2", Arrays.asList("Amit", "Sneha")))),
                new School("School B", Arrays.asList(new ClassRoom("Class 1", Arrays.asList("Vikram", "Ananya")))));

        // Problem 1: Get all classrooms from all schools
        // TODO: Use flatMap to get List<ClassRoom>
        List<ClassRoom> allClassRooms = schools.stream().flatMap(e->e.getClassRooms().stream()).toList();
        System.out.println(allClassRooms);


        // Problem 2: Get all student names from all schools
        // TODO: This needs TWO flatMaps! First flatten schools to classrooms,
        //       then flatten classrooms to students
        // Expected: [Rajesh, Priya, Amit, Sneha, Vikram, Ananya]
        List<String>  studentsList = schools.stream().flatMap(school -> school.getClassRooms().stream().flatMap(n -> n.getStudents().stream())).toList();
        System.out.println(studentsList);


        // Problem 3: Count total number of students across all schools
        // TODO: Flatten twice, then count
        Long  totalStudents = schools.stream().flatMap(school -> school.getClassRooms().stream().flatMap(n -> n.getStudents().stream())).count();
        System.out.println(totalStudents);

    }

    static class School {
        String name;
        @Getter
        List<ClassRoom> classRooms;

        School(String name, List<ClassRoom> classRooms) {
            this.name = name;
            this.classRooms = classRooms;
        }

    }

    static class ClassRoom {
        String className;
        @Getter
        List<String> students;

        ClassRoom(String className, List<String> students) {
            this.className = className;
            this.students = students;
        }

    }
}
