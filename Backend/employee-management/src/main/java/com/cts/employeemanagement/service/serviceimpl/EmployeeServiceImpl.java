package com.cts.employeemanagement.service.serviceimpl;

import com.cts.employeemanagement.exception.NoRecordsException;
import com.cts.employeemanagement.model.EmployeeDetails;
import com.cts.employeemanagement.repository.EmployeeRepository;
import com.cts.employeemanagement.service.EmployeeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;




//    @Override
//    public List<EmployeeDetails> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

    @Override
    public Optional<EmployeeDetails> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

//    @Override
//    public EmployeeDetails getEmployeeById(long id) throws NoRecordsException {
//        EmployeeDetails emp=employeeRepository.getReferenceById(id);
//        if(!employeeRepository.existsById(id)){
//            throw new NoRecordsException("No Record is found with id "+id);
//        }
//        return emp;
//    }

    @Override
    public List<EmployeeDetails> getAllEmployees() throws NoRecordsException {
        List<EmployeeDetails> empList=employeeRepository.findAll();
        if(empList.isEmpty()){
            throw new NoRecordsException("No Employee Records found");
        }
        return empList;
    }

    @SneakyThrows
    public boolean registerEmployee(EmployeeDetails employee){
        if(employee==null){
            throw new NullPointerException("Object is null");
        }
        try{
            employeeRepository.save(employee);
        }catch (Exception e){
            throw new Exception("Invalid data");
        }
        return true;
    }

    @SneakyThrows
    public boolean deleteEmployeeById(long id) {
       try{
           employeeRepository.deleteById(id);
       }
       catch (Exception e)
       {
           throw  new Exception("The Record is not presented with id"+id);
       }
       return true;
    }

//    @Override
//    public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails) {
//
//        Long id = employeeDetails.getId();
//        EmployeeDetails emp=  employeeRepository.findById(id).get();
//        emp.setFirstName(employeeDetails.getFirstName());
//        emp.setLastName(employeeDetails.getLastName());
//        emp.setEmail(employeeDetails.getEmail());
//        return employeeRepository.save(emp);
//    }

    @Override
    public  String getUserName(long id)
    {
        return employeeRepository.findById(id).get().getFirstName().toString();
    }


}
