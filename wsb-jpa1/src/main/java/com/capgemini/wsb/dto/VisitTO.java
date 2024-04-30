package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private Long id;

    private String description;

    private LocalDateTime time;

    private DoctorEntity doctorEntity;

    private List<MedicalTreatmentEntity> medicalTreatmentEntity;

    private PatientEntity patientEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
