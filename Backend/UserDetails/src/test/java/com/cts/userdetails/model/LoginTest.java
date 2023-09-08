package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoginTest {
 
    @Test
    void testConstructor() {
        Login actualLogin = new Login();
        actualLogin.setPassword("alice@123");
        actualLogin.setUserName(1L);
        assertEquals("alice@123", actualLogin.getPassword());
        assertEquals(1L, actualLogin.getUserName().longValue());
    }


    @Test
    void testConstructor2() {
        Login actualLogin = new Login(1L, "alice@123");
        actualLogin.setPassword("alice@123");
        actualLogin.setUserName(1L);
        assertEquals("alice@123", actualLogin.getPassword());
        assertEquals(1L, actualLogin.getUserName().longValue());
    }
}

