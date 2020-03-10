package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.entity.Employee;
import com.example.employee.entity.Projects;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.ProjectRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean CreateEmployee(EmployeeDTO employeeDTO) throws Exception {


        Employee employee = null;
        if (employeeRepository.getOne(employeeDTO.getEmployeeId()).getEmployeeId() != null) {
            employee = employeeRepository.save(
                    new Employee(
                            employeeDTO.getEmployeeId(),
                            employeeDTO.getFirstName(),
                            employeeDTO.getLastName(),
                            employeeDTO.getEmail(),
                            employeeDTO.getGender(),
                            employeeDTO.getDepartment()
                    ));
            for (String projectName : employeeDTO.getProjectWorkOn()) {
                projectRepository.save(new Projects(
                        employeeDTO.getEmployeeId(),
                        projectName
                ));

            }
        } else {
            return false;
        }
        if (employee.getEmployeeId().equals(employeeDTO)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdateEmployee(EmployeeDTO employeeDTO) throws Exception {
        Employee employee = employeeRepository.save(
                new Employee(
                        employeeDTO.getEmployeeId(),
                        employeeDTO.getFirstName(),
                        employeeDTO.getLastName(),
                        employeeDTO.getEmail(),
                        employeeDTO.getGender(),
                        employeeDTO.getDepartment()
                ));
        for (String projectName : employeeDTO.getProjectWorkOn()) {
            projectRepository.save(new Projects(
                    employeeDTO.getEmployeeId(),
                    projectName
            ));

        }
        if (employee.getEmployeeId().equals(employeeDTO)) {
            return true;
        }
        return false;

    }

    @Override
    public boolean DeleteEmployee(String employeeDTO) throws Exception {
        employeeRepository.deleteById(employeeDTO);
        return true;
    }

    @Override
    public EmployeeDTO FindEmployee(String id) throws Exception {
        ArrayList<String> projectLists = new ArrayList<>();
        Employee one = employeeRepository.getOne(id);
        List<Projects> projects = projectRepository.findAll();
        for (Projects p :
                projects) {
            if (p.getEmployeeID().equals(id)) {


                projectLists.add(p.getProjectName());
            }
        }
        return new EmployeeDTO(
                one.getEmployeeId(),
                one.getFirstName(),
                one.getLastName(),
                one.getEmail(),
                one.getGender(),
                one.getDepartment(), projectLists
        );
    }

    @Override
    public List<EmployeeDTO> FindAll() throws Exception {
        ArrayList<EmployeeDTO> employeeDTOS = new ArrayList<>();
        ArrayList<String> projectLists = new ArrayList<>();
        List<Employee> one = employeeRepository.findAll();
        for (Employee e : one) {
            List<Projects> projects = projectRepository.findAll();
            for (Projects p :
                    projects) {
                if (p.getEmployeeID().equals(e.getEmployeeId())) {
                    projectLists.add(p.getProjectName());
                }
            }
            employeeDTOS.add(new EmployeeDTO(
                    e.getEmployeeId(),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getEmail(),
                    e.getGender(),
                    e.getDepartment(), projectLists
            ));
        }
        return employeeDTOS;
    }
}
