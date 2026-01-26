package com.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee implements Comparable<Employee>{

    private String name;
    private String city;
    private String department;
    private Integer salary;
    private Integer age;

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", city='" + city + '\'' + ", department='" + department + '\'' + ", salary=" + salary + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }
}
