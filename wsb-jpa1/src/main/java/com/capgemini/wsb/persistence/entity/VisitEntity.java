package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// relacja dwustronna
	@ManyToOne
	private DoctorEntity doctorEntity;

	// relacja jednostronna
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "visit_id")
	private List<MedicalTreatmentEntity> medicalTreatmentEntity;

	//relacja jednostronna po stronie własciciela(visit)/dziecka(patient)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Patient_Entity_ID")
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
