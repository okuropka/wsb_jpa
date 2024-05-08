package com.capgemini.wsb.dto;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private Long id;
    private String description;
    private LocalDateTime time;
    private DoctorTO doctorTO;
    private MedicalTreatmentTO medicalTreatmentTO;
    private PatientTO patientTO;

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

    public PatientTO getPatientTO() { return patientTO; }

    public void setPatientTO(PatientTO patientTO) { this.patientTO = patientTO; }

    public DoctorTO getDoctorTO() { return doctorTO; }

    public void setDoctorTO(DoctorTO doctorTO) { this.doctorTO = doctorTO; }

    public MedicalTreatmentTO getMedicalTreatment() { return medicalTreatmentTO; }

    public void setMedicalTreatment(MedicalTreatmentTO medicalTreatmentTO) { this.medicalTreatmentTO = medicalTreatmentTO; }
}
