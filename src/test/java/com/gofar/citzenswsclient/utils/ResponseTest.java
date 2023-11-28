package com.gofar.citzenswsclient.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ResponseTest {

    private Response response;

    @BeforeEach
    void setUp() {
        response = Response.builder()
                .message("Failed").build();
    }

    @Test
    void gettersTest() {
        assertEquals("Failed", response.getMessage());
        assertNull(response.getData());
        assertEquals(0, response.getCode());
    }

    @Test
    void settersTest() {
        Object data = new Object();
        response.setCode(200);
        response.setData(data);
        response.setMessage("Success");
        assertEquals(200, response.getCode());
        assertEquals("Success", response.getMessage());
        assertEquals(data, response.getData());
    }
}
