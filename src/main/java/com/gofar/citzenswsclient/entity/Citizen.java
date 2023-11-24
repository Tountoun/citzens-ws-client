package com.gofar.citzenswsclient.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDate;


@Document(collection = "citizen")
public class Citizen {
    @Id
    @Field(name = "cin")
    private String cin;
    @Field(name = "firstname")
    private String firstname;
    @Field(name = "lastname")
    private String lastname;
    @Field(name = "mother")
    private String mother;
    @Field(name = "father")
    private String father;
    @Field(name = "height")
    private double height;
    @Field(name = "job")
    private String job;
    @Field(name = "blood")
    private String bloodType;
    @Field(name = "birth_day", targetType = FieldType.DATE_TIME)
    private LocalDate birthDay;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "cin='" + cin + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
