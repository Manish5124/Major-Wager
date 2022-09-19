package com.cts.Employeemanagmentsystem.service.serviceimpl;

import com.cts.Employeemanagmentsystem.model.EmployeeDetails;
import com.cts.Employeemanagmentsystem.repository.EmployeeRepository;
import com.cts.Employeemanagmentsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeDetails> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }
}
