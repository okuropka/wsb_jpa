package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@Column(name = "VISIT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TIME", nullable = false)
	private LocalDateTime time;

	// relacja dwukierunkowa
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctorEntity;

	// relacja jednokierunkowa po stronie rodzica (VisitEntity)
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "MEDICAL_TREATMENT_ID")
	private List<MedicalTreatmentEntity> medicalTreatmentEntities;

	//relacja dwukierunkowa
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
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
