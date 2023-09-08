package com.cts.jobmodulemicroservices.feign;

import com.cts.jobmodulemicroservices.model.employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Employee-Microservice", url = "localhost:9051/employee")
public interface EmployeeClient {

    @GetMapping(value = "/employeedetails/{id}")
    public employee getEmployeeDetailsById(@PathVariable long id);

    @PostMapping("/register")
    public boolean registerEmployee(@RequestBody employee employeeData);

}
