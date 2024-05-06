package com.capgemini.wsb.dto;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private Long id;
    private String description;
    private LocalDateTime time;
    private Long doctorId;
    private List<MedicalTreatmentTO> medicalTreatmentTOs;
    private Long patientId;

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

    public Long getPatientId() { return patientId; }

    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }

    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public List<MedicalTreatmentTO> getMedicalTreatments() { return medicalTreatmentTOs; }

    public void setMedicalTreatments(List<MedicalTreatmentTO> medicalTreatmentTOs) { this.medicalTreatmentTOs = medicalTreatmentTOs; }
}
