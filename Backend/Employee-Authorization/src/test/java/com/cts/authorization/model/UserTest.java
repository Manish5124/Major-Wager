package com.cts.authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setUserName(String)}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setPassword("iloveyou");
        actualUser.setUserName("janedoe");
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("janedoe", actualUser.getUserName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setUserName(String)}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("janedoe", "iloveyou");
        actualUser.setPassword("iloveyou");
        actualUser.setUserName("janedoe");
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("janedoe", actualUser.getUserName());
    }
}

