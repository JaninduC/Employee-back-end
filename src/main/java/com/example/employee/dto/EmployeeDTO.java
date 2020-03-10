package com.example.employee.dto;

import java.util.List;

public class EmployeeDTO {

    private String EmployeeId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Gender;
    private String Department;
    private List<String> ProjectWorkOn;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeId, String firstName, String lastName, String email, String gender, String department, List<String> projectWorkOn) {
        EmployeeId = employeeId;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Gender = gender;
        Department = department;
        ProjectWorkOn = projectWorkOn;
    }

    public List<String> getProjectWorkOn() {
        return ProjectWorkOn;
    }

    public void setProjectWorkOn(List<String> projectWorkOn) {
        ProjectWorkOn = projectWorkOn;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Department='" + Department + '\'' +
                ", ProjectWorkOn=" + ProjectWorkOn +
                '}';
    }
}
