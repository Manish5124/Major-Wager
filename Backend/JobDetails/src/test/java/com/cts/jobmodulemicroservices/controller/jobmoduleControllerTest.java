package com.cts.jobmodulemicroservices.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.cts.jobmodulemicroservices.model.job;
import com.cts.jobmodulemicroservices.service.Jobservice;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {jobmoduleController.class})
@ExtendWith(SpringExtension.class)
class jobmoduleControllerTest {
    @Autowired
    private jobmoduleController jobController;

    @MockBean
    private Jobservice jobservice;

    /**
     * Method under test: {@link jobmoduleController#abortJob(long, long)}
     */
    @Test
    void testAbortJob() throws Exception {
        when(jobservice.abortedJob(anyLong(), anyLong())).thenReturn("Aborted Job");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/abortJob/{jobId}/{empId}", 123L, 123L);
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("\"Aborted Job\""));
    }

    /**
     * Method under test: {@link jobmoduleController#abortJob(long, long)}
     */
    @Test
    void testAbortJob2() throws Exception {
        when(jobservice.abortedJob(anyLong(), anyLong())).thenReturn("Aborted Job");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/abortJob/{jobId}/{empId}", 123L, 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("\"Aborted Job\""));
    }

    /**
     * Method under test: {@link jobmoduleController#allocateJob(long, long)}
     */
    @Test
    void testAllocateJob() throws Exception {
        when(jobservice.AllocatedJob(anyLong(), anyLong())).thenReturn("Allocated Job");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/allocateJob/{jobId}/{empId}", 123L,
                123L);
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("\"Allocated Job\""));
    }

    /**
     * Method under test: {@link jobmoduleController#allocateJob(long, long)}
     */
    @Test
    void testAllocateJob2() throws Exception {
        when(jobservice.AllocatedJob(anyLong(), anyLong())).thenReturn("Allocated Job");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/allocateJob/{jobId}/{empId}", 123L, 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("\"Allocated Job\""));
    }

    /**
     * Method under test: {@link jobmoduleController#completeJob(long, long)}
     */
    @Test
    void testCompleteJob() throws Exception {
        when(jobservice.CompletedJob(anyLong(), anyLong())).thenReturn("Completed Job");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/completeJob/{jobId}/{empId}", 123L,
                123L);
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("\"Completed Job\""));
    }

    /**
     * Method under test: {@link jobmoduleController#completeJob(long, long)}
     */
    @Test
    void testCompleteJob2() throws Exception {
        when(jobservice.CompletedJob(anyLong(), anyLong())).thenReturn("Completed Job");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/completeJob/{jobId}/{empId}", 123L, 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("\"Completed Job\""));
    }

    /**
     * Method under test: {@link jobmoduleController#createJob(job)}
     */
    @Test
    void testCreateJob() throws Exception {
        when(jobservice.createJobs((job) any())).thenReturn(new ArrayList<>());

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(jobdetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createJob")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link jobmoduleController#deleteJob(long)}
     */
    @Test
    void testDeleteJob() throws Exception {
        when(jobservice.deleteJobById(anyLong())).thenReturn("42");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/deleteJob");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link jobmoduleController#getAllJobsDetails()}
     */
    @Test
    void testGetAllJobsDetails() throws Exception {
        when(jobservice.getAllJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobs");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link jobmoduleController#getAllJobsDetails()}
     */
    @Test
    void testGetAllJobsDetails2() throws Exception {
        when(jobservice.getAllJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/jobs");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link jobmoduleController#getJobById(int)}
     */
    @Test
    void testGetJobById() throws Exception {
        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        when(jobservice.getJobDetailById(anyLong())).thenReturn(jobdetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jobById/{id}", 1);
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"jobId\":123,\"starttime\":\"Starttime\",\"endtime\":\"Endtime\",\"profit\":1,\"status\":\"Status\"}"));
    }

    /**
     * Method under test: {@link jobmoduleController#getJobsById(String)}
     */
    @Test
    void testGetJobsById() throws Exception {
        when(jobservice.getJobDetailByStatus((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getJobByStatus/{status}", "Status");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link jobmoduleController#getJobsById(String)}
     */
    @Test
    void testGetJobsById2() throws Exception {
        when(jobservice.getJobDetailByStatus((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getJobByStatus/{status}", "Status");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link jobmoduleController#modifyJobDetail(job)}
     */
    @Test
    void testModifyJobDetail() throws Exception {
        when(jobservice.modifyJobs((job) any())).thenReturn(new ArrayList<>());

        job jobdetails = new job();
        jobdetails.setEndtime("Endtime");
        jobdetails.setJobId(123L);
        jobdetails.setProfit(1L);
        jobdetails.setStarttime("Starttime");
        jobdetails.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(jobdetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/modifyJob")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

