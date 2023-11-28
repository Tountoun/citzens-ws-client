package com.gofar.citzenswsclient.utils;

import com.gofar.citzenswsclient.ws.BloodGroup;
import com.gofar.citzenswsclient.ws.Citizen;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MappingUtilsTest {

    @Test
    void shouldMapCitizenFromWebServiceToCitizenEntityTest() throws DatatypeConfigurationException {
        Citizen citizenFromWs = new Citizen();
        citizenFromWs.setMotherName("Mimi");
        citizenFromWs.setFatherName("Pipi");
        citizenFromWs.setLastName("Lili");
        citizenFromWs.setFatherName("Fifi");
        citizenFromWs.setCni("2322222");
        citizenFromWs.setBloodGroup(BloodGroup.ARN);
        citizenFromWs.setJob("Data Scientist");
        citizenFromWs.setHeight(3.2);
        citizenFromWs.setBirthDay(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(2012, 12, 3).toString()));
        com.gofar.citzenswsclient.entity.Citizen citizen = MappingUtils.citizenWsToCitizenEntity(citizenFromWs);
        assertEquals(citizen.getBloodType(), citizenFromWs.getBloodGroup().value());
        assertEquals(citizen.getLastname(), citizenFromWs.getLastName());
        assertEquals(citizen.getFirstname(), citizenFromWs.getFirstName());
        assertEquals(citizen.getHeight(), citizenFromWs.getHeight());
        assertEquals(LocalDate.of(2012, 12, 3), citizen.getBirthDay());
    }
}
