package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@Column(name = "MEDICAL_TREATMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "TREATMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	// relacja jednokierunkowa po stronie rodzica (VisitEntity)
		@ManyToOne(cascade = CascadeType.REMOVE)
	private VisitEntity visitEntity;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

}
