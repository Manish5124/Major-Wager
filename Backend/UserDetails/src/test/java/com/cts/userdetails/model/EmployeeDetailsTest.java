package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeDetailsTest {

    @Test
    void testConstructor() {
        EmployeeDetails actualEmployeeDetails = new EmployeeDetails();
        actualEmployeeDetails.setAllocated_job("Allocated job");
        actualEmployeeDetails.setEmail("alice@123");
        actualEmployeeDetails.setFirstName("alice");
        actualEmployeeDetails.setId(123L);
        actualEmployeeDetails.setLastName("Doe");
        actualEmployeeDetails.setSalary(10.0d);
        assertEquals("Allocated job", actualEmployeeDetails.getAllocated_job());
        assertEquals("alice@123", actualEmployeeDetails.getEmail());
        assertEquals("alice", actualEmployeeDetails.getFirstName());
        assertEquals(123L, actualEmployeeDetails.getId());
        assertEquals("Doe", actualEmployeeDetails.getLastName());
        assertEquals(10.0d, actualEmployeeDetails.getSalary());
    }


    @Test
    void testConstructor2() {
        EmployeeDetails actualEmployeeDetails = new EmployeeDetails(123L, "alice", "Doe", 10.0d, "alice@123",
                "Allocated job");

        assertEquals("Allocated job", actualEmployeeDetails.getAllocated_job());
        assertEquals(10.0d, actualEmployeeDetails.getSalary());
        assertEquals("Doe", actualEmployeeDetails.getLastName());
        assertEquals(123L, actualEmployeeDetails.getId());
        assertEquals("alice", actualEmployeeDetails.getFirstName());
        assertEquals("alice@123", actualEmployeeDetails.getEmail());
    }
}

