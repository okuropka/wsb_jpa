package com.capgemini.wsb.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "IS_WOMAN", nullable = false)
	private boolean isWoman;

	@Column(name = "HEIGHT_cm")
	private int height;

	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String telephoneNumber;

	// relacja jednokierunkowa po stronie rodzica (PatientEntity)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AddressEntity addressEntity;

	// relacja dwukierunkowa
	@Column(name = "VISIT_ID")
	@OneToMany(mappedBy = "patientEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<VisitEntity> visitEntities;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PATIENT_NUMBER", nullable = false)
	private String patientNumber;

	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getIsWoman() { return isWoman; }

	public void setIsWoman(boolean isWoman) {this.isWoman = isWoman;}

	public int getHeight() { return height;}

	public void setHeight(int height) {this.height = height;}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressEntity getAddressEntity() { return addressEntity; }

	public void setAddressEntity(AddressEntity addressEntity) { this.addressEntity = addressEntity; }

	public List<VisitEntity> getVisitEntities() { return visitEntities; }

	public void setVisitEntities(List<VisitEntity> visitEntities) { this.visitEntities = visitEntities; }
}
