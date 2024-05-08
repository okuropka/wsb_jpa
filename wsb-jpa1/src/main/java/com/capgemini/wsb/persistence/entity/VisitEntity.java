package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "TIME", nullable = false)
	private LocalDateTime time;

	// relacja dwukierunkowa
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctorEntity;

	// relacja jednokierunkowa po stronie rodzica (VisitEntity)
	@OneToMany(mappedBy = "visitEntity", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<MedicalTreatmentEntity> medicalTreatmentEntities;

	//relacja dwukierunkowa
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patientEntity;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

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

	public PatientEntity getPatientEntity() { return patientEntity; }

	public void setPatientEntity(PatientEntity patientEntity) { this.patientEntity = patientEntity; }

	public DoctorEntity getDoctorEntity() { return doctorEntity; }

	public void setDoctorEntity(DoctorEntity doctorEntity) { this.doctorEntity = doctorEntity; }

	public List<MedicalTreatmentEntity> getMedicalTreatments() { return medicalTreatmentEntities; }

	public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatmentEntities) { this.medicalTreatmentEntities = medicalTreatmentEntities; }
}
