package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "MEDICALTREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "TREATMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	// relacja jednokierunkowa po stronie rodzica (VisitEntity)
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "VISIT_ID")
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

	public VisitEntity getVisitEntity() { return visitEntity; }

	public void setVisitEntity(VisitEntity visitEntity) { this.visitEntity = visitEntity; }
}
