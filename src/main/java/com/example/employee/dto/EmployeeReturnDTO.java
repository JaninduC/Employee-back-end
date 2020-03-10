package com.example.employee.dto;

import java.util.List;

public class EmployeeReturnDTO {
    private EmployeeDTO employeeDTO;
    private List<String> projects;

    public EmployeeReturnDTO() {
    }

    public EmployeeReturnDTO(EmployeeDTO employeeDTO, List<String> projects) {
        this.employeeDTO = employeeDTO;
        this.projects = projects;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "EmployeeReturnDTO{" +
                "employeeDTO=" + employeeDTO +
                ", projects=" + projects +
                '}';
    }
}
