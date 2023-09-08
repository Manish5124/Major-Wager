package com.cts.employeemanagement.service;
import com.cts.employeemanagement.exception.NoRecordsException;
import com.cts.employeemanagement.model.EmployeeDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService  {

    Optional<EmployeeDetails> getEmployeeById(long id) throws NoRecordsException;

    //  getAllEmployees Method helps to get the records of all employee
    List<EmployeeDetails> getAllEmployees() throws NoRecordsException;


    //  getEmployeeById Method helps to get the record of employee by id
//    public Object getEmployeeById(long id);


    // registerEmployee Method helps to register the employee record
    public boolean registerEmployee(EmployeeDetails employee);


    // deleteEmployeeById Method helps to delete the record of employee
    public boolean deleteEmployeeById(long id);

    String getUserName(long id);


//    public  EmployeeDetails updateEmployee(EmployeeDetails employeeDetails);

}
