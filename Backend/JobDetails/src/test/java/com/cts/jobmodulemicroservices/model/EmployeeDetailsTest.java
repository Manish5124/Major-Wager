package com.cts.jobmodulemicroservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class EmployeeDetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link employee#EmployeeDetails()}
     *   <li>{@link employee#setAllocatedJobs(List)}
     *   <li>{@link employee#setEmail(String)}
     *   <li>{@link employee#setFirstName(String)}
     *   <li>{@link employee#setId(long)}
     *   <li>{@link employee#setLastName(String)}
     *   <li>{@link employee#setSalary(long)}
     *   <li>{@link employee#getAllocatedJobs()}
     *   <li>{@link employee#getEmail()}
     *   <li>{@link employee#getFirstName()}
     *   <li>{@link employee#getId()}
     *   <li>{@link employee#getLastName()}
     *   <li>{@link employee#getSalary()}
     * </ul>
     */
    @Test
    void testConstructor() {
        employee actualEmployeeDetails = new employee();
        ArrayList<job> jobdetailsList = new ArrayList<>();
        actualEmployeeDetails.setAllocatedJobs(jobdetailsList);
        actualEmployeeDetails.setEmail("jane.doe@example.org");
        actualEmployeeDetails.setFirstName("Jane");
        actualEmployeeDetails.setId(123L);
        actualEmployeeDetails.setLastName("Doe");
        actualEmployeeDetails.setSalary(1L);
        assertSame(jobdetailsList, actualEmployeeDetails.getAllocatedJobs());
        assertEquals("jane.doe@example.org", actualEmployeeDetails.getEmail());
        assertEquals("Jane", actualEmployeeDetails.getFirstName());
        assertEquals(123L, actualEmployeeDetails.getId());
        assertEquals("Doe", actualEmployeeDetails.getLastName());
        assertEquals(1L, actualEmployeeDetails.getSalary());
    }

    /**
     * Method under test: {@link employee#EmployeeDetails(long, String, String, long, String, List)}
     */
    @Test
    void testConstructor2() {
        employee actualEmployeeDetails = new employee(123L, "Jane", "Doe", 1L, "jane.doe@example.org",
                new ArrayList<>());

        assertTrue(actualEmployeeDetails.getAllocatedJobs().isEmpty());
        assertEquals(1L, actualEmployeeDetails.getSalary());
        assertEquals("Doe", actualEmployeeDetails.getLastName());
        assertEquals(123L, actualEmployeeDetails.getId());
        assertEquals("Jane", actualEmployeeDetails.getFirstName());
        assertEquals("jane.doe@example.org", actualEmployeeDetails.getEmail());
    }
}

