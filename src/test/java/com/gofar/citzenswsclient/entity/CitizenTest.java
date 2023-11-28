package com.gofar.citzenswsclient.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CitizenTest {

    private Citizen citizen;

    @BeforeEach
    public void setUp() {
        citizen = new Citizen();
        citizen.setCin("223-111-115");
        citizen.setHeight(1.5);
        citizen.setMother("Buji");
        citizen.setFather("Ikoye");
        citizen.setFirstname("Giue");
        citizen.setLastname("Samuel");
    }

    @Test
    void gettersTest() {
        assertEquals("223-111-115", citizen.getCin());
        assertEquals(1.5, citizen.getHeight());
        assertEquals("Buji", citizen.getMother());
        assertEquals("Samuel", citizen.getLastname());
    }

    @Test
    void setterTest() {
        citizen.setLastname("Koji");
        citizen.setBloodType("ORP");
        citizen.setBirthDay(LocalDate.of(2003, 4, 23));

        assertEquals("Koji", citizen.getLastname());
        assertNotNull(citizen.getBloodType());
        assertNotNull(citizen.getBirthDay());
        assertEquals(LocalDate.of(2003, 4, 23), citizen.getBirthDay());
    }

    @Test
    void toStringTest() {
        String toString = "Citizen{cin='223-111-115', firstname='Giue', lastname='Samuel', bloodType='null'}";
        assertEquals(toString, citizen.toString());
    }
}
