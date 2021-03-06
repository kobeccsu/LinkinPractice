package com.leizhou.roomwebapp.repository;

import com.leizhou.roomwebapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
