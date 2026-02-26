package com.stream;

import com.code.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static void main(String[] args) {

        System.out.println("=== FLATMAP BASICS ===");

        // TODO: Task 1 - Flatten list of lists
        List<List<Integer>> numberLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("\n1. Flatten list of lists:");
        List<Integer> flatNumbers = numberLists.stream().flatMap(List::stream).toList();
        System.out.println(flatNumbers);


        // TODO: Task 2 - Get all characters from list of strings
        List<String> words = Arrays.asList("Stream", "API", "Java");
        // Expected: S, t, r, e, a, m, A, P, I, J, a, v, a
        System.out.println("\n2. All characters from words:");
        words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .forEach(System.out::println);


        // TODO: Task 3 - Split sentences into words
        List<String> sentences = Arrays.asList(
                "Java is awesome",
                "Streams are powerful",
                "Learning is fun"
        );
        // Get all unique words
        System.out.println("\n3. All unique words from sentences:");
        sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().sorted() .forEach(System.out::println);


        System.out.println("\n\n=== FLATMAP WITH EMPLOYEES ===");

        // Department class with employees
        class Department {
            String name;
            List<Employee> employees;

            Department(String name, List<Employee> employees) {
                this.name = name;
                this.employees = employees;
            }

            public String getName() { return name; }
            public List<Employee> getEmployees() { return employees; }
        }

        List<Department> departments = Arrays.asList(
                new Department("IT", Arrays.asList(
                        new Employee("Rajesh Kumar", "Mumbai", "IT", 75000, 32),
                        new Employee("Amit Patel", "Delhi", "IT", 85000, 35),
                        new Employee("Vikram Singh", "Pune", "IT", 95000, 38)
                )),
                new Department("HR", Arrays.asList(
                        new Employee("Priya Sharma", "Bangalore", "HR", 65000, 28),
                        new Employee("Neha Gupta", "Bangalore", "HR", 55000, 25)
                )),
                new Department("Finance", Arrays.asList(
                        new Employee("Sneha Reddy", "Hyderabad", "Finance", 70000, 30),
                        new Employee("Rahul Verma", "Mumbai", "Finance", 80000, 33)
                ))
        );

        // TODO: Task 4 - Get all employees from all departments
        System.out.println("\n4. All employees from all departments:");
        var empList = departments.stream().flatMap(department -> department.getEmployees().stream()).map(Employee::getName).toList();
        System.out.println(empList);


        // TODO: Task 5 - Get names of all employees earning > 70000
        System.out.println("\n5. Names of employees earning > 70000:");
        var empSal = departments.stream().flatMap(department -> department.getEmployees().stream()).filter(e -> e.getSalary() > 70000).
                map(Employee::getName).toList();
        System.out.println(empSal);


        // TODO: Task 6 - Get total count of all employees across departments
        System.out.println("\n6. Total employee count:");
        var empCount = departments.stream().flatMap(department -> department.getEmployees().stream()).count();



        // TODO: Task 7 - Get all unique cities where employees work
        System.out.println("\n7. Unique cities:");
        var uniqueCity = departments.stream().flatMap(department -> department.getEmployees().stream()).
                map(Employee::getCity).distinct().sorted().toList();
        System.out.println(uniqueCity);


        // TODO: Task 8 - Get average salary across all departments
        System.out.println("\n8. Average salary (all departments):");
        double avgSalary = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println(avgSalary);

        System.out.println("\n\n=== FLATMAP WITH ARRAYS ===");

        // TODO: Task 9 - Flatten array of arrays
        Integer[][] numberArrays = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        // Convert to single list
        System.out.println("\n9. Flatten array of arrays:");
        var flattenArray = Arrays.stream(numberArrays).flatMap(Arrays::stream).toList();
        System.out.println(flattenArray);


        // TODO: Task 10 - Get all skills from employees
        class EmployeeWithSkills {
            String name;
            List<String> skills;

            EmployeeWithSkills(String name, List<String> skills) {
                this.name = name;
                this.skills = skills;
            }

            public String getName() { return name; }
            public List<String> getSkills() { return skills; }
        }

        List<EmployeeWithSkills> employeesWithSkills = Arrays.asList(
                new EmployeeWithSkills("Rajesh", Arrays.asList("Java", "Spring", "MySQL")),
                new EmployeeWithSkills("Priya", Arrays.asList("Python", "Django", "PostgreSQL")),
                new EmployeeWithSkills("Amit", Arrays.asList("Java", "Microservices", "AWS"))
        );

        // Get all unique skills
        System.out.println("\n10. All unique skills:");
        var uniqueSkills = employeesWithSkills.stream().flatMap(e -> e.getSkills().stream()).distinct().toList();
        System.out.println(uniqueSkills);


        // BONUS: Task 11 - Get employees who know "Java"
        System.out.println("\n11. BONUS - Employees who know Java:");
        employeesWithSkills.stream().filter(e->e.getSkills().contains("Java")).map(EmployeeWithSkills::getName).sorted().toList();

    }
}
