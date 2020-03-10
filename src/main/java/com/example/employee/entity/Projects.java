package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;
    private String EmployeeID;
    private String ProjectName;

    public Projects() {
    }

    public Projects(String EmployeeId, String projectName) {

        this.EmployeeID = EmployeeId;
        ProjectName = projectName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "pid=" + pid +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", ProjectName='" + ProjectName + '\'' +
                '}';
    }
}
