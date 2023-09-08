package com.cts.employeemanagement.repository;

import com.cts.employeemanagement.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Long> {
}
