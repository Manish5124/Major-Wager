package com.cts.jobmodulemicroservices.service.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.jobmodulemicroservices.feign.EmployeeClient;
import com.cts.jobmodulemicroservices.model.employee;
import com.cts.jobmodulemicroservices.model.job;
import com.cts.jobmodulemicroservices.repository.jobRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cts.jobmodulemicroservices.service.Jobserviceimpl;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Jobserviceimpl.class})
@ExtendWith(SpringExtension.class)
class JobserviceimplTest {
    @MockBean
    private EmployeeClient employeeClient;

    @MockBean
    private jobRepository jobdetailsRepository;

    @Autowired
    private Jobserviceimpl jobserviceimpl;

    /**
     * Method under test: {@link Jobserviceimpl#getAllJobs()}
     */
    @Test
    void testGetAllJobs() {
        ArrayList<job> jobdetailsList = new ArrayList<>();
        when(jobdetailsRepository.findAll()).thenReturn(jobdetailsList);
        List<job> actualAllJobs = jobserviceimpl.getAllJobs();
        assertSame(jobdetailsList, actualAllJobs);
        assertTrue(actualAllJobs.isEmpty());
        verify(jobdetailsRepository).findAll();
    }

    /**
     * Method under test: {@link Jobserviceimpl#createJobs(job)}
     */
    @Test
    void testCreateJobs() {
        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails);
        ArrayList<job> jobdetailsList = new ArrayList<>();
        when(jobdetailsRepository.findAll()).thenReturn(jobdetailsList);

        job jobdetails1 = new job();
        jobdetails1.setEndtime("Endtime");
        jobdetails1.setJobId(123L);
        jobdetails1.setProfit(1L);
        jobdetails1.setStarttime("Starttime");
        jobdetails1.setStatus("Status");
        List<job> actualCreateJobsResult = jobserviceimpl.createJobs(jobdetails1);
        assertSame(jobdetailsList, actualCreateJobsResult);
        assertTrue(actualCreateJobsResult.isEmpty());
        verify(jobdetailsRepository).save((job) any());
        verify(jobdetailsRepository).findAll();
        assertEquals("Not Started", jobdetails1.getStatus());
    }

    /**
     * Method under test: {@link Jobserviceimpl#deleteJobById(long)}
     */
    @Test
    void testDeleteJobById() {
        doNothing().when(jobdetailsRepository).deleteById((Long) any());
        assertEquals("Successfully Deleted!", jobserviceimpl.deleteJobById(123L));
        verify(jobdetailsRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#getJobDetailById(long)}
     */
    @Test
    void testGetJobDetailById() {
        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        Optional<job> ofResult = Optional.of(jobdetails);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(jobdetails, jobserviceimpl.getJobDetailById(123L));
        verify(jobdetailsRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#AllocatedJob(long, long)}
     */
    @Test
    void testAllocatedJob() throws Exception {
        employee employeeDetails = new employee();
        employeeDetails.setAllocatedJobs(new ArrayList<>());
        employeeDetails.setEmail("jane.doe@example.org");
        employeeDetails.setFirstName("Jane");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeClient.registerEmployee((employee) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById(anyLong())).thenReturn(employeeDetails);

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        Optional<job> ofResult = Optional.of(jobdetails);

        job jobdetails1 = new job();
        jobdetails1.setEndtime("Endtime");
        jobdetails1.setJobId(123L);
        jobdetails1.setProfit(1L);
        jobdetails1.setStarttime("Starttime");
        jobdetails1.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails1);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Job added to employee", jobserviceimpl.AllocatedJob(1L, 1L));
        verify(employeeClient).registerEmployee((employee) any());
        verify(employeeClient).getEmployeeDetailsById(anyLong());
        verify(jobdetailsRepository).save((job) any());
        verify(jobdetailsRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#AllocatedJob(long, long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAllocatedJob2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cts.jobDetails.model.Jobdetails.getJobId()" because "jobDetail" is null
        //       at com.cts.jobDetails.service.serviceimpl.Jobserviceimpl.AllocatedJob(Jobserviceimpl.java:111)
        //   See https://diff.blue/R013 to resolve this issue.

        employee employeeDetails = new employee();
        employeeDetails.setAllocatedJobs(new ArrayList<>());
        employeeDetails.setEmail("jane.doe@example.org");
        employeeDetails.setFirstName("Jane");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeClient.registerEmployee((employee) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById(anyLong())).thenReturn(employeeDetails);

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(Optional.empty());
        jobserviceimpl.AllocatedJob(1L, 1L);
    }

    /**
     * Method under test: {@link Jobserviceimpl#CompletedJob(long, long)}
     */
    @Test
    void testCompletedJob() {
        employee employeeDetails = new employee();
        employeeDetails.setAllocatedJobs(new ArrayList<>());
        employeeDetails.setEmail("jane.doe@example.org");
        employeeDetails.setFirstName("Jane");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeClient.registerEmployee((employee) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById(anyLong())).thenReturn(employeeDetails);

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        Optional<job> ofResult = Optional.of(jobdetails);

        job jobdetails1 = new job();
        jobdetails1.setEndtime("Endtime");
        jobdetails1.setJobId(123L);
        jobdetails1.setProfit(1L);
        jobdetails1.setStarttime("Starttime");
        jobdetails1.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails1);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Job is Completed", jobserviceimpl.CompletedJob(123L, 1L));
        verify(employeeClient).registerEmployee((employee) any());
        verify(employeeClient).getEmployeeDetailsById(anyLong());
        verify(jobdetailsRepository).save((job) any());
        verify(jobdetailsRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#CompletedJob(long, long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCompletedJob2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cts.jobDetails.model.Jobdetails.getJobId()" because "jobDetail" is null
        //       at com.cts.jobDetails.service.serviceimpl.Jobserviceimpl.CompletedJob(Jobserviceimpl.java:141)
        //   See https://diff.blue/R013 to resolve this issue.

        employee employeeDetails = mock(employee.class);
        when(employeeDetails.getAllocatedJobs()).thenReturn(new ArrayList<>());
        when(employeeDetails.getSalary()).thenReturn(1L);
        doNothing().when(employeeDetails).setAllocatedJobs((List<job>) any());
        doNothing().when(employeeDetails).setEmail((String) any());
        doNothing().when(employeeDetails).setFirstName((String) any());
        doNothing().when(employeeDetails).setId(anyLong());
        doNothing().when(employeeDetails).setLastName((String) any());
        doNothing().when(employeeDetails).setSalary(anyLong());
        employeeDetails.setAllocatedJobs(new ArrayList<>());
        employeeDetails.setEmail("jane.doe@example.org");
        employeeDetails.setFirstName("Jane");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeClient.registerEmployee((employee) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById(anyLong())).thenReturn(employeeDetails);

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(Optional.empty());
        jobserviceimpl.CompletedJob(123L, 1L);
    }

    /**
     * Method under test: {@link Jobserviceimpl#abortedJob(long, long)}
     */
    @Test
    void testAbortedJob() {
        employee employeeDetails = new employee();
        employeeDetails.setAllocatedJobs(new ArrayList<>());
        employeeDetails.setEmail("jane.doe@example.org");
        employeeDetails.setFirstName("Jane");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeClient.registerEmployee((employee) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById(anyLong())).thenReturn(employeeDetails);

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        Optional<job> ofResult = Optional.of(jobdetails);

        job jobdetails1 = new job();
        jobdetails1.setEndtime("Endtime");
        jobdetails1.setJobId(123L);
        jobdetails1.setProfit(1L);
        jobdetails1.setStarttime("Starttime");
        jobdetails1.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails1);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Job is aborted", jobserviceimpl.abortedJob(123L, 1L));
        verify(employeeClient).registerEmployee((employee) any());
        verify(employeeClient).getEmployeeDetailsById(anyLong());
        verify(jobdetailsRepository).save((job) any());
        verify(jobdetailsRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#abortedJob(long, long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAbortedJob2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cts.jobDetails.model.Jobdetails.getJobId()" because "jobDetail" is null
        //       at com.cts.jobDetails.service.serviceimpl.Jobserviceimpl.abortedJob(Jobserviceimpl.java:188)
        //   See https://diff.blue/R013 to resolve this issue.

        employee employeeDetails = new employee();
        employeeDetails.setAllocatedJobs(new ArrayList<>());
        employeeDetails.setEmail("jane.doe@example.org");
        employeeDetails.setFirstName("Jane");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        when(employeeClient.registerEmployee((employee) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById(anyLong())).thenReturn(employeeDetails);

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(Optional.empty());
        jobserviceimpl.abortedJob(123L, 1L);
    }

    /**
     * Method under test: {@link Jobserviceimpl#modifyJobs(job)}
     */
    @Test
    void testModifyJobs() {
        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        Optional<job> ofResult = Optional.of(jobdetails);

        job jobdetails1 = new job();
        jobdetails1.setEndtime("Endtime");
        jobdetails1.setJobId(123L);
        jobdetails1.setProfit(1L);
        jobdetails1.setStarttime("Starttime");
        jobdetails1.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails1);
        ArrayList<job> jobdetailsList = new ArrayList<>();
        when(jobdetailsRepository.findAll()).thenReturn(jobdetailsList);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(ofResult);

        job jobdetails2 = new job();
        jobdetails2.setEndtime("Endtime");
        jobdetails2.setJobId(123L);
        jobdetails2.setProfit(1L);
        jobdetails2.setStarttime("Starttime");
        jobdetails2.setStatus("Status");
        List<job> actualModifyJobsResult = jobserviceimpl.modifyJobs(jobdetails2);
        assertSame(jobdetailsList, actualModifyJobsResult);
        assertTrue(actualModifyJobsResult.isEmpty());
        verify(jobdetailsRepository).save((job) any());
        verify(jobdetailsRepository).findAll();
        verify(jobdetailsRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#modifyJobs(job)}
     */
    @Test
    void testModifyJobs2() {
        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        when(jobdetailsRepository.save((job) any())).thenReturn(jobdetails);
        ArrayList<job> jobdetailsList = new ArrayList<>();
        when(jobdetailsRepository.findAll()).thenReturn(jobdetailsList);
        when(jobdetailsRepository.findById((Long) any())).thenReturn(Optional.empty());

        job jobdetails1 = new job();
        jobdetails1.setEndtime("Endtime");
        jobdetails1.setJobId(123L);
        jobdetails1.setProfit(1L);
        jobdetails1.setStarttime("Starttime");
        jobdetails1.setStatus("Status");
        List<job> actualModifyJobsResult = jobserviceimpl.modifyJobs(jobdetails1);
        assertSame(jobdetailsList, actualModifyJobsResult);
        assertTrue(actualModifyJobsResult.isEmpty());
        verify(jobdetailsRepository).findAll();
        verify(jobdetailsRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Jobserviceimpl#getJobDetailByStatus(String)}
     */
    @Test
    void testGetJobDetailByStatus() {
        ArrayList<job> jobdetailsList = new ArrayList<>();
        when(jobdetailsRepository.findJobdetailsByStatus((String) any())).thenReturn(jobdetailsList);
        List<job> actualJobDetailByStatus = jobserviceimpl.getJobDetailByStatus("Status");
        assertSame(jobdetailsList, actualJobDetailByStatus);
        assertTrue(actualJobDetailByStatus.isEmpty());
        verify(jobdetailsRepository).findJobdetailsByStatus((String) any());
    }
}

