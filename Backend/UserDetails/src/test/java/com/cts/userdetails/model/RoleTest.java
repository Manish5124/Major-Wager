package com.cts.userdetails.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {

    @Test
    void testConstructor() {
        Role actualRole = new Role();
        actualRole.setId(123L);
        actualRole.setRoleId(123L);
        actualRole.setRoleName("Role Name");
        assertEquals(123L, actualRole.getId());
        assertEquals(123L, actualRole.getRoleId());
        assertEquals("Role Name", actualRole.getRoleName());
    }


    @Test
    void testConstructor2() {
        Role actualRole = new Role(123L, 123L, "Role Name");

        assertEquals(123L, actualRole.getId());
        assertEquals("Role Name", actualRole.getRoleName());
        assertEquals(123L, actualRole.getRoleId());
    }
}

