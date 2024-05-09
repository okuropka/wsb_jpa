package com.capgemini.wsb.dto;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class BasicPatientTO implements Serializable
{
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

}
