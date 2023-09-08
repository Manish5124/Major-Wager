package com.cts.employeemanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class EmployeeDetailsTest {

    @Test
    void testConstructor() {
        EmployeeDetails actualEmployeeDetails = new EmployeeDetails();
        HashSet<Jobdetails> jobdetailsSet = new HashSet<>();
        actualEmployeeDetails.setAllocatedjobs(jobdetailsSet);
        actualEmployeeDetails.setEmail("alice@123");
        actualEmployeeDetails.setFirstName("alice");
        actualEmployeeDetails.setId(123L);
        actualEmployeeDetails.setLastName("Doe");
        actualEmployeeDetails.setSalary(1L);
        assertSame(jobdetailsSet, actualEmployeeDetails.getAllocatedjobs());
        assertEquals("alice@123", actualEmployeeDetails.getEmail());
        assertEquals("alice", actualEmployeeDetails.getFirstName());
        assertEquals(123L, actualEmployeeDetails.getId());
        assertEquals("Doe", actualEmployeeDetails.getLastName());
        assertEquals(1L, actualEmployeeDetails.getSalary());
    }


    @Test
    void testConstructor2() {
        EmployeeDetails actualEmployeeDetails = new EmployeeDetails(123L, "alice", "Doe", 1L, "alice@123",
                new HashSet<>());

        assertTrue(actualEmployeeDetails.getAllocatedjobs().isEmpty());
        assertEquals(1L, actualEmployeeDetails.getSalary());
        assertEquals("Doe", actualEmployeeDetails.getLastName());
        assertEquals(123L, actualEmployeeDetails.getId());
        assertEquals("alice", actualEmployeeDetails.getFirstName());
        assertEquals("alice@123", actualEmployeeDetails.getEmail());
    }
}

