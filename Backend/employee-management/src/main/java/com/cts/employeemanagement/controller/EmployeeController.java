package com.cts.employeemanagement.controller;


import com.cts.employeemanagement.exception.NoRecordsException;
import com.cts.employeemanagement.model.EmployeeDetails;
import com.cts.employeemanagement.service.EmployeeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/AllEmployeeDetail")
    public List<EmployeeDetails> getAllEmployees() throws NoRecordsException {
           return employeeService.getAllEmployees();
    }

    @SneakyThrows
    @GetMapping("/EmployeeDetail/{id}") // Rest end point
    public Optional<EmployeeDetails> getEmployeeDetailsById(@PathVariable long id) throws NoRecordsException {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping("/RegisterEmployee")
    public boolean registerEmployee(@RequestBody EmployeeDetails employee){
        return employeeService.registerEmployee(employee);
    }

    @GetMapping("/fetchUserName/{empId}")
    public String getUserNameById(@PathVariable long empId)
    {
        return employeeService.getUserName(empId);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public boolean deleteEmployeeById(@PathVariable long id)
    {

        return employeeService.deleteEmployeeById(id);
    }


}
