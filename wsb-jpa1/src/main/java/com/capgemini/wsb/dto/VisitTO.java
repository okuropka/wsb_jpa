package com.capgemini.wsb.dto;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private Long id;
    private String description;
    private LocalDateTime time;
    private BasicDoctorTO basicDoctorTO;
    //private DoctorTO doctorTO;
    private MedicalTreatmentTO medicalTreatmentTO;
    private BasicPatientTO basicPatientTO;
    //private PatientTO patientTO;

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

    public BasicPatientTO getBasicPatientTO() { return basicPatientTO; }

    public void setBasicPatientTO(BasicPatientTO BasicPatientTO) { this.basicPatientTO = basicPatientTO; }

    public BasicDoctorTO getBasicDoctorTO() { return basicDoctorTO; }

    public void setBasicDoctorTO(BasicDoctorTO basicDoctorTO) { this.basicDoctorTO = basicDoctorTO; }

    public MedicalTreatmentTO getMedicalTreatment() { return medicalTreatmentTO; }

    public void setMedicalTreatment(MedicalTreatmentTO medicalTreatmentTO) { this.medicalTreatmentTO = medicalTreatmentTO; }
}
