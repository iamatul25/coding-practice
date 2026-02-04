package com.practice.dto;

public class EmployeeDTO {
    private String fullName;
    private String email;
    private String grade;

    public EmployeeDTO(String fullName, String email, String grade) {
        this.fullName = fullName;
        this.email = email;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{name='" + fullName + "', email='" + email + "', grade='" + grade + "'}";
    }
}