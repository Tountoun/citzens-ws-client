package com.gofar.citzenswsclient.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CitizenDtoTest {

    private CitizenDto dto;

    @BeforeEach
    void setUp() {
        dto = new CitizenDto("223-111-115", "Holly", "Mark", "ORP", "AI Developer", "Nick", "Muka");
    }

    @Test
    void gettersTest() {
        assertEquals("223-111-115", dto.getCin());
        assertEquals("Nick", dto.getFather());
        assertEquals("Muka", dto.getMother());
        assertEquals("Mark", dto.getLastname());
        assertEquals("Holly", dto.getFirstname());
        assertEquals("ORP", dto.getBlood());
        assertEquals("AI Developer", dto.getJob());
    }

    @Test
    void setterTest() {
        dto.setLastname("Koji");
        dto.setCin("333-232-002");
        dto.setBlood("BRP");
        dto.setJob("Computer Science Department Director");

        assertEquals("Koji", dto.getLastname());
        assertEquals("BRP", dto.getBlood());
        assertEquals("Computer Science Department Director", dto.getJob());
        assertEquals("333-232-002", dto.getCin());
    }

    @Test
    void getKeyValuesTest() {
        Map<String, String> map = dto.getKeyValues();
        assertEquals(6, map.size());
        assertNull(map.get("cin"));
        assertEquals(map.get("firstname"), dto.getFirstname());
        assertEquals(map.get("lastname"), dto.getLastname());
        assertEquals(map.get("blood"), dto.getBlood());
        assertEquals(map.get("job"), dto.getJob());
        assertEquals(map.get("father"), dto.getFather());
        assertEquals(map.get("mother"), dto.getMother());
    }
}
