package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public boolean CreateEmployee(EmployeeDTO employeeDTO) throws Exception;

    public boolean UpdateEmployee(EmployeeDTO employeeDTO) throws Exception;

    public boolean DeleteEmployee(String employeeDTO) throws Exception;

    public EmployeeDTO FindEmployee(String id) throws Exception;

    public List<EmployeeDTO> FindAll() throws Exception;

}
