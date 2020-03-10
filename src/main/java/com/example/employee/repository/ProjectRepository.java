package com.example.employee.repository;

import com.example.employee.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, String> {
}
