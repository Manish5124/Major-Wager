package com.cts.jobmodulemicroservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JobdetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link job#Jobdetails()}
     *   <li>{@link job#setEndtime(String)}
     *   <li>{@link job#setJobId(Long)}
     *   <li>{@link job#setProfit(long)}
     *   <li>{@link job#setStarttime(String)}
     *   <li>{@link job#setStatus(String)}
     *   <li>{@link job#getEndtime()}
     *   <li>{@link job#getJobId()}
     *   <li>{@link job#getProfit()}
     *   <li>{@link job#getStarttime()}
     *   <li>{@link job#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        job actualJobdetails = new job();
        actualJobdetails.setEndtime("Endtime");
        actualJobdetails.setJobId(123L);
        actualJobdetails.setProfit(1L);
        actualJobdetails.setStarttime("Starttime");
        actualJobdetails.setStatus("Status");
        assertEquals("Endtime", actualJobdetails.getEndtime());
        assertEquals(123L, actualJobdetails.getJobId().longValue());
        assertEquals(1L, actualJobdetails.getProfit());
        assertEquals("Starttime", actualJobdetails.getStarttime());
        assertEquals("Status", actualJobdetails.getStatus());
    }

    /**
     * Method under test: {@link job#Jobdetails(Long, String, String, long, String)}
     */
    @Test
    void testConstructor2() {
        job actualJobdetails = new job(123L, "Starttime", "Endtime", 1L, "Status");

        assertEquals("Endtime", actualJobdetails.getEndtime());
        assertEquals("Status", actualJobdetails.getStatus());
        assertEquals("Starttime", actualJobdetails.getStarttime());
        assertEquals(1L, actualJobdetails.getProfit());
        assertEquals(123L, actualJobdetails.getJobId().longValue());
    }
}

