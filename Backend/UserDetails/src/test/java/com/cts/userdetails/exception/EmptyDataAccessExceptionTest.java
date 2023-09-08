package com.cts.userdetails.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EmptyDataAccessExceptionTest {

    @Test
    void testConstructor() {
        EmptyDataAccessException actualEmptyDataAccessException = new EmptyDataAccessException("An error occurred");
        assertEquals("No data is found", actualEmptyDataAccessException.get());
        assertEquals(0, actualEmptyDataAccessException.getSuppressed().length);
        assertEquals("An error occurred", actualEmptyDataAccessException.getMessage());
        assertEquals("An error occurred", actualEmptyDataAccessException.getLocalizedMessage());
        assertNull(actualEmptyDataAccessException.getCause());
    }
}

