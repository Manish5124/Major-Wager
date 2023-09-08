package com.cts.employeemanagement.service.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.employeemanagement.exception.NoRecordsException;
import com.cts.employeemanagement.model.EmployeeDetails;
import com.cts.employeemanagement.model.Jobdetails;
import com.cts.employeemanagement.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    void testGetEmployeeById() {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        Optional<EmployeeDetails> ofResult = Optional.of(employeeDetails);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<EmployeeDetails> actualEmployeeById = employeeServiceImpl.getEmployeeById(123L);
        assertSame(ofResult, actualEmployeeById);
        assertTrue(actualEmployeeById.isPresent());
        verify(employeeRepository).findById((Long) any());
    }

    @Test
    void testGetAllEmployees() throws NoRecordsException {
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(NoRecordsException.class, () -> employeeServiceImpl.getAllEmployees());
        verify(employeeRepository).findAll();
    }


    @Test
    void testGetAllEmployees2() throws NoRecordsException {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);

        ArrayList<EmployeeDetails> employeeDetailsList = new ArrayList<>();
        employeeDetailsList.add(employeeDetails);
        when(employeeRepository.findAll()).thenReturn(employeeDetailsList);
        List<EmployeeDetails> actualAllEmployees = employeeServiceImpl.getAllEmployees();
        assertSame(employeeDetailsList, actualAllEmployees);
        assertEquals(1, actualAllEmployees.size());
        verify(employeeRepository).findAll();
    }



    @Test
    void testRegisterEmployee() {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeRepository.save((EmployeeDetails) any())).thenReturn(employeeDetails);

        EmployeeDetails employeeDetails1 = new EmployeeDetails();
        employeeDetails1.setAllocatedjobs(new HashSet<>());
        employeeDetails1.setEmail("alice@123");
        employeeDetails1.setFirstName("alice");
        employeeDetails1.setId(123L);
        employeeDetails1.setLastName("Doe");
        employeeDetails1.setSalary(1L);
        assertTrue(employeeServiceImpl.registerEmployee(employeeDetails1));
        verify(employeeRepository).save((EmployeeDetails) any());
    }


    @Test
    void testRegisterEmployee2() {
        when(employeeRepository.save((EmployeeDetails) any())).thenThrow(new NullPointerException());

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        assertThrows(Exception.class, () -> employeeServiceImpl.registerEmployee(employeeDetails));
        verify(employeeRepository).save((EmployeeDetails) any());
    }

    @Test
    void testDeleteEmployeeById() {
        doNothing().when(employeeRepository).deleteById((Long) any());
        assertTrue(employeeServiceImpl.deleteEmployeeById(123L));
        verify(employeeRepository).deleteById((Long) any());
    }


    @Test
    void testDeleteEmployeeById2() {
        doThrow(new NullPointerException()).when(employeeRepository).deleteById((Long) any());
        assertThrows(Exception.class, () -> employeeServiceImpl.deleteEmployeeById(123L));
        verify(employeeRepository).deleteById((Long) any());
    }


    @Test
    void testGetUserName() {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        Optional<EmployeeDetails> ofResult = Optional.of(employeeDetails);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("alice", employeeServiceImpl.getUserName(123L));
        verify(employeeRepository).findById((Long) any());
    }


}

