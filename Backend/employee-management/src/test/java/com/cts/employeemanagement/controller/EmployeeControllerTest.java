package com.cts.employeemanagement.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.cts.employeemanagement.model.EmployeeDetails;
import com.cts.employeemanagement.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;


    @Test
    void testGetAllEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/AllEmployeeDetail");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testRegisterEmployee() throws Exception {
        when(employeeService.registerEmployee((EmployeeDetails) any())).thenReturn(true);

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        String content = (new ObjectMapper()).writeValueAsString(employeeDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/RegisterEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }


    @Test
    void testDeleteEmployeeById() throws Exception {
        when(employeeService.deleteEmployeeById(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteEmployee/{id}", 123L);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }


    @Test
    void testDeleteEmployeeById2() throws Exception {
        when(employeeService.deleteEmployeeById(anyLong())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/deleteEmployee/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }


    @Test
    void testGetEmployeeDetailsById() throws Exception {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocatedjobs(new HashSet<>());
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(1L);
        Optional<EmployeeDetails> ofResult = Optional.of(employeeDetails);
        when(employeeService.getEmployeeById(anyLong())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/EmployeeDetail/{id}", 123L);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"firstName\":\"alice\",\"lastName\":\"Doe\",\"salary\":1,\"email\":\"alice@123\",\"allocatedjobs"
                                        + "\":[]}"));
    }


    @Test
    void testGetUserNameById() throws Exception {
        when(employeeService.getUserName(anyLong())).thenReturn("alicedoe");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchUserName/{empId}", 123L);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("alicedoe"));
    }


    @Test
    void testGetUserNameById2() throws Exception {
        when(employeeService.getUserName(anyLong())).thenReturn("alicedoe");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/fetchUserName/{empId}", 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("alicedoe"));
    }
}

