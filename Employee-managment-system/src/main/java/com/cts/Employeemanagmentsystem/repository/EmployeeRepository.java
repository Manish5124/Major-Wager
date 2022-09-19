package com.cts.Employeemanagmentsystem.repository;

import com.cts.Employeemanagmentsystem.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Long> {
}
