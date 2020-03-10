package com.example.employee.contorller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class ExampleController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean CreateNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        boolean result = false;
        try {
            result = employeeService.CreateEmployee(employeeDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean UpdateNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        boolean result = false;
        try {
            result = employeeService.UpdateEmployee(employeeDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean RemoveEmployee(@PathVariable("id") String id) {
        boolean result = false;
        try {
            result = employeeService.DeleteEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO FindEmployee(@PathVariable("id") String id) {
        EmployeeDTO employeeDTO = null;
        try {
            employeeDTO = employeeService.FindEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeDTO;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> FindAll() {
        List<EmployeeDTO> employeeDTOS = null;
        try {
            employeeDTOS = employeeService.FindAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeDTOS;
    }
}
