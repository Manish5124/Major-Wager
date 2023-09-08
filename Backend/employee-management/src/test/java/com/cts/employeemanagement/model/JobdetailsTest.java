package com.cts.employeemanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class JobdetailsTest {

    @Test
    void testConstructor() {
        Jobdetails actualJobdetails = new Jobdetails();
        actualJobdetails.setEndtime("Endtime");
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        actualJobdetails.setEngagedEmployee(employeeDetails);
        actualJobdetails.setJobId(123L);
        actualJobdetails.setProfit(1L);
        actualJobdetails.setStarttime("Starttime");
        actualJobdetails.setStatus("Status");
        assertEquals("Endtime", actualJobdetails.getEndtime());
        assertSame(employeeDetails, actualJobdetails.getEngagedEmployee());
        assertEquals(123L, actualJobdetails.getJobId().longValue());
        assertEquals(1L, actualJobdetails.getProfit());
        assertEquals("Starttime", actualJobdetails.getStarttime());
        assertEquals("Status", actualJobdetails.getStatus());
    }

    @Test
    void testConstructor2() {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        Jobdetails actualJobdetails = new Jobdetails(123L, "Starttime", "Endtime", 1L, "Status", employeeDetails);

        assertEquals("Endtime", actualJobdetails.getEndtime());
        assertEquals("Status", actualJobdetails.getStatus());
        assertEquals("Starttime", actualJobdetails.getStarttime());
        assertEquals(1L, actualJobdetails.getProfit());
        assertEquals(123L, actualJobdetails.getJobId().longValue());
        assertSame(employeeDetails, actualJobdetails.getEngagedEmployee());
    }
}

