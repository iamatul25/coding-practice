package com.code;

@FunctionalInterface
public interface EmployeeFilter {
    boolean test(Employee emp);
}
