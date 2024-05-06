package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.io.Serializable;

public class AddressTO implements Serializable
{
    private Long id;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;
    private DoctorTO doctorTO;
    private PatientTO patientTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public DoctorTO getDoctorTO() { return doctorTO; }

    public void setDoctorTO(DoctorTO doctorTO) { this.doctorTO = doctorTO; }

    public PatientTO getPatientTO() { return patientTO; }

    public void setPatientTO(PatientTO patientTO) { this.patientTO = patientTO; }
}
