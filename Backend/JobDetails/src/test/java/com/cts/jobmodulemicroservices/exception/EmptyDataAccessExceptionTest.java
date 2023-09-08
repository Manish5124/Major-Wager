package com.cts.jobmodulemicroservices.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EmptyDataAccessExceptionTest {
    /**
     * Method under test: {@link EmptyDataAccessException#EmptyDataAccessException(String)}
     */
    @Test
    void testConstructor() {
        EmptyDataAccessException actualEmptyDataAccessException = new EmptyDataAccessException("An error occurred");
        assertNull(actualEmptyDataAccessException.getCause());
        assertEquals(0, actualEmptyDataAccessException.getSuppressed().length);
        assertEquals("An error occurred", actualEmptyDataAccessException.getMessage());
        assertEquals("An error occurred", actualEmptyDataAccessException.getLocalizedMessage());
    }
}

