package com.cts.Employeemanagmentsystem.controller;

import com.cts.Employeemanagmentsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//     get all employees
    @GetMapping("/EmployeeDetail")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
    }


//    get employee by Id
    @GetMapping("/EmployeeDetail/{id}")
    public ResponseEntity<?> getEmployeeDetailsById(@PathVariable Long id) {
    return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.ACCEPTED);
   }



}
