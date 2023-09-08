package com.cts.userdetails.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.User;
import com.cts.userdetails.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    
    @Test
    void testLoadUserByName() throws Exception {
        when(userService.loadUserByName(anyLong())).thenReturn(new Login());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/loadUserByName/{userName}", 1L);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"userName\":null,\"password\":null}"));
    }

  
    @Test
    void testLoadUserByName2() throws Exception {
        when(userService.loadUserByName(anyLong())).thenReturn(new Login());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/loadUserByName/{userName}", 1L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"userName\":null,\"password\":null}"));
    }

   
    @Test
    void testHandleValidationExceptions() {
        assertTrue(
                userController
                        .handleValidationExceptions(
                                new MethodArgumentNotValidException(null, new BindException("Target", "Object Name")))
                        .isEmpty());
    }

   
    @Test
    void testHandleValidationExceptions2() {
        MethodParameter parameter = mock(MethodParameter.class);
        assertTrue(
                userController
                        .handleValidationExceptions(
                                new MethodArgumentNotValidException(parameter, new BindException("Target", "Object Name")))
                        .isEmpty());
    }

   


 
    @Test
    void testDeleteUserDetails() throws Exception {
        when(userService.deleteUser(anyLong())).thenReturn("Delete User");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteUser/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(410))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete User"));
    }

   
    @Test
    void testDeleteUserDetails2() throws Exception {
        when(userService.deleteUser(anyLong())).thenReturn("Delete User");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/deleteUser/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(410))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete User"));
    }

    @Test
    void testFetchRoleByName() throws Exception {
        when(userService.fetchRole((String) any())).thenReturn("Fetch Role");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fetchRole").param("username", "foo");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Fetch Role"));
    }

 
    @Test
    void testGetAllUserData() throws Exception {
        when(userService.getAllUser()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllUserData");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

  
    @Test
    void testGetAllUserData2() throws Exception {
        when(userService.getAllUser()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getAllUserData");
        getResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(getResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetUserData() throws Exception {
        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        when(userService.getUserById(anyLong())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getUserById/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"firstName\":\"alice\",\"lastName\":\"Doe\",\"email\":\"alice@gmail.com\",\"password\":\"alice@123\","
                                        + "\"roles\":[]}"));
    }

   
    @Test
    void testRegisterUserDetails() throws Exception {
        when(userService.registerUser((User) any())).thenReturn("Register User");

        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/RegisterUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Register User"));
    }

  
    @Test
    void testUpdateUser() throws Exception {
        when(userService.UpdateUser((User) any())).thenReturn("2020-03-01");

        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/UpdateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

   
    @Test
    void testUpdateUser2() throws Exception {
        when(userService.UpdateUser((User) any()))
                .thenThrow(new MethodArgumentNotValidException(null, new BindException("Target", "?")));

        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/UpdateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

  
    @Test
    void testUpdateUser3() throws Exception {
        BindException bindException = new BindException("Target", "?");
        bindException.addError(new ObjectError("?", "?"));
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(null,
                bindException);

        when(userService.UpdateUser((User) any())).thenThrow(methodArgumentNotValidException);

        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/UpdateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

