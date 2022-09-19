package com.cts.Employeemanagmentsystem.service;

import com.cts.Employeemanagmentsystem.model.EmployeeDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService  {

//    get all details of employee
    List<EmployeeDetails> getAllEmployees();

//    get employee details by id
    Optional<EmployeeDetails> getEmployeeById(long id);



}
