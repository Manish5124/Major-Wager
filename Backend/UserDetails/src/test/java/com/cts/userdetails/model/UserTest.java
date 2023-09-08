package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("alice@gmail.com");
        actualUser.setFirstName("alice");
        actualUser.setId(123L);
        actualUser.setLastName("Doe");
        actualUser.setPassword("alice@123");
        ArrayList<Role> roleList = new ArrayList<>();
        actualUser.setRoles(roleList);
        assertEquals("alice@gmail.com", actualUser.getEmail());
        assertEquals("alice", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("alice@123", actualUser.getPassword());
        assertSame(roleList, actualUser.getRoles());
    }


    @Test
    void testConstructor2() {
        User actualUser = new User(123L, "alice", "Doe", "alice@gmail.com", "alice@123", new ArrayList<>());

        assertEquals("alice@gmail.com", actualUser.getEmail());
        assertTrue(actualUser.getRoles().isEmpty());
        assertEquals("alice@123", actualUser.getPassword());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals(123L, actualUser.getId());
        assertEquals("alice", actualUser.getFirstName());
    }
}

