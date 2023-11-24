package com.gofar.citzenswsclient.utils;

import com.gofar.citzenswsclient.entity.Citizen;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class MappingUtils {

    private MappingUtils() {
        // Default constructor
    }

    public static Citizen citizenWsToCitizenEntity(com.gofar.citzenswsclient.ws.Citizen citizen) {
        Citizen citizen1 = new Citizen();
        citizen1.setCin(citizen.getCni());
        citizen1.setFirstname(citizen.getFirstName());
        citizen1.setLastname(citizen.getLastName());
        citizen1.setFather(citizen.getFatherName());
        citizen1.setMother(citizen.getMotherName());
        citizen1.setHeight(citizen.getHeight());
        citizen1.setJob(citizen.getJob());
        citizen1.setBloodType(citizen.getBloodGroup().value());
        citizen1.setBirthDay(xmlGregorianToLocalDate(citizen.getBirthDay()));
        return citizen1;
    }

    private static LocalDate xmlGregorianToLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        return LocalDate.of(xmlGregorianCalendar.getYear(), xmlGregorianCalendar.getMonth(), xmlGregorianCalendar.getDay());
    }
}
