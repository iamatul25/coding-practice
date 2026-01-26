package com.code;

public class Employee implements Comparable<Employee>{

    private String name;
    private String city;
    private String department;
    private Integer salary;
    private Integer age;

    public Employee(String name, String city, String department, Integer salary, Integer age) {
        this.name = name;
        this.city = city;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", city='" + city + '\'' + ", department='" + department + '\'' + ", salary=" + salary + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }
}
