package com.cts.userdetails.feign;


import com.cts.userdetails.model.EmployeeDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Employee-Microservice", url = "localhost:8081/employee")
public interface EmployeeClient {


    @PostMapping(value = "/RegisterEmployee")
    public boolean registerEmployee(@RequestBody EmployeeDetails employee);

    @DeleteMapping("/deleteEmployee/{id}")
    public boolean deleteEmployeeById(@PathVariable long id);

    @GetMapping("/EmployeeDetail/{id}")
    public EmployeeDetails getEmployeeDetailsById(@PathVariable Long id);


}
