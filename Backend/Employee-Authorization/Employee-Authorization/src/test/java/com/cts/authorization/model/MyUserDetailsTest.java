package com.cts.authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class MyUserDetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MyUserDetails#MyUserDetails(User)}
     *   <li>{@link MyUserDetails#isAccountNonExpired()}
     *   <li>{@link MyUserDetails#isAccountNonLocked()}
     *   <li>{@link MyUserDetails#isCredentialsNonExpired()}
     *   <li>{@link MyUserDetails#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setUserName("janedoe");
        MyUserDetails actualMyUserDetails = new MyUserDetails(user);
        assertTrue(actualMyUserDetails.isAccountNonExpired());
        assertTrue(actualMyUserDetails.isAccountNonLocked());
        assertTrue(actualMyUserDetails.isCredentialsNonExpired());
        assertTrue(actualMyUserDetails.isEnabled());
    }

    /**
     * Method under test: {@link MyUserDetails#MyUserDetails(User)}
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setUserName("janedoe");
        assertEquals(1L, (new MyUserDetails(user)).getId());
    }

    /**
     * Method under test: {@link MyUserDetails#getId()}
     */
    @Test
    void testGetId() {
        assertEquals(0L, (new MyUserDetails(new User())).getId());
    }

    /**
     * Method under test: {@link MyUserDetails#getAuthorities()}
     */
    @Test
    void testGetAuthorities() {
        Collection<? extends GrantedAuthority> actualAuthorities = (new MyUserDetails(new User())).getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("ROLE_ADMIN", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Method under test: {@link MyUserDetails#getPassword()}
     */
    @Test
    void testGetPassword() {
        assertNull((new MyUserDetails(new User())).getPassword());
    }

    /**
     * Method under test: {@link MyUserDetails#getUsername()}
     */
    @Test
    void testGetUsername() {
        assertNull((new MyUserDetails(new User())).getUsername());
    }
}

