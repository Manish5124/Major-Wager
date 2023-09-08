package com.cts.userdetails.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.userdetails.feign.EmployeeClient;
import com.cts.userdetails.model.EmployeeDetails;
import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.User;
import com.cts.userdetails.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private EmployeeClient employeeClient;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testRegisterUser() {
        when(employeeClient.registerEmployee((EmployeeDetails) any())).thenReturn(true);

        User user = new User();
        user.setEmail("alice@123");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        when(userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("alice@123");
        user1.setFirstName("alice");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("alice@123");
        user1.setRoles(new ArrayList<>());
        assertEquals("User is registered successfully.", userServiceImpl.registerUser(user1));
        verify(employeeClient).registerEmployee((EmployeeDetails) any());
        verify(userRepository).save((User) any());
    }

    @Test
    void testRegisterUser3() {
        when(employeeClient.registerEmployee((EmployeeDetails) any())).thenReturn(true);

        User user = new User();
        user.setEmail("alice@123");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        when(userRepository.save((User) any())).thenReturn(user);
        User user1 = mock(User.class);
        when(user1.getEmail()).thenReturn("alice@123");
        when(user1.getFirstName()).thenReturn("alice");
        when(user1.getLastName()).thenReturn("Doe");
        when(user1.getId()).thenReturn(0L);
        doNothing().when(user1).setEmail((String) any());
        doNothing().when(user1).setFirstName((String) any());
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLastName((String) any());
        doNothing().when(user1).setPassword((String) any());
        doNothing().when(user1).setRoles((List<Role>) any());
        user1.setEmail("alice@123");
        user1.setFirstName("alice");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("alice@123");
        user1.setRoles(new ArrayList<>());
        assertEquals("User is registered successfully.", userServiceImpl.registerUser(user1));
        verify(employeeClient).registerEmployee((EmployeeDetails) any());
        verify(userRepository).save((User) any());
        verify(user1, atLeast(1)).getEmail();
        verify(user1, atLeast(1)).getFirstName();
        verify(user1, atLeast(1)).getLastName();
        verify(user1).getId();
        verify(user1).setEmail((String) any());
        verify(user1).setFirstName((String) any());
        verify(user1).setId(anyLong());
        verify(user1).setLastName((String) any());
        verify(user1).setPassword((String) any());
        verify(user1).setRoles((List<Role>) any());
    }


    @Test
    void testUpdateUser() throws Exception {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setAllocated_job("Allocated job");
        employeeDetails.setEmail("alice@123");
        employeeDetails.setFirstName("alice");
        employeeDetails.setId(123L);
        employeeDetails.setLastName("Doe");
        employeeDetails.setSalary(10.0d);
        when(employeeClient.registerEmployee((EmployeeDetails) any())).thenReturn(true);
        when(employeeClient.getEmployeeDetailsById((Long) any())).thenReturn(employeeDetails);

        User user = new User();
        user.setEmail("alice@123");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setEmail("alice@123");
        user1.setFirstName("alice");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("alice@123");
        user1.setRoles(new ArrayList<>());
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setEmail("alice@123");
        user2.setFirstName("alice");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("alice@123");
        user2.setRoles(new ArrayList<>());
        assertEquals("successfully updated", userServiceImpl.UpdateUser(user2));
        verify(employeeClient).registerEmployee((EmployeeDetails) any());
        verify(employeeClient).getEmployeeDetailsById((Long) any());
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
    }


    @Test
    void testDeleteUser() {
        when(employeeClient.deleteEmployeeById(anyLong())).thenReturn(true);
        doNothing().when(userRepository).deleteById((Long) any());
        assertEquals("successfully deleted 123", userServiceImpl.deleteUser(123L));
        verify(employeeClient).deleteEmployeeById(anyLong());
        verify(userRepository).deleteById((Long) any());
    }



    @Test
    void testGetAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<User> actualAllUser = userServiceImpl.getAllUser();
        assertSame(userList, actualAllUser);
        assertTrue(actualAllUser.isEmpty());
        verify(userRepository).findAll();
    }


    @Test
    void testLoadUserByName() {
        User user = new User();
        user.setEmail("alice@123");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        when(userRepository.getReferenceById((Long) any())).thenReturn(user);
        Login actualLoadUserByNameResult = userServiceImpl.loadUserByName(1L);
        assertEquals("alice@123", actualLoadUserByNameResult.getPassword());
        assertEquals(123L, actualLoadUserByNameResult.getUserName().longValue());
        verify(userRepository).getReferenceById((Long) any());
    }


    @Test
    void testFetchRole3() {
        Role role = new Role();
        role.setId(123L);
        role.setRoleId(123L);
        role.setRoleName("Role Name");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = new User();
        user.setEmail("alice@123");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(roleList);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Role Name", userServiceImpl.fetchRole("42"));
        verify(userRepository).findById((Long) any());
    }

      @Test
    void testGetUserById() {
        User user = new User();
        user.setEmail("alice@123");
        user.setFirstName("alice");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("alice@123");
        user.setRoles(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, userServiceImpl.getUserById(123L));
        verify(userRepository).findById((Long) any());
    }


}

