package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ADDRESS_LINE_1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE_2")
	private String addressLine2;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	// relacja dwukierunkowa
	@OneToOne(mappedBy = "addressEntity")
	private DoctorEntity doctorEntity;

	// relacja dwukierunkowa
	@OneToOne(mappedBy = "addressEntity")
	private PatientEntity patientEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }

	public String getAddressLine2() { return addressLine2; }

	public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }

	public String getPostalCode() {	return postalCode; }

	public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

	public DoctorEntity getDoctorEntity() { return doctorEntity; }

	public void setDoctorEntity(DoctorEntity doctorEntity) { this.doctorEntity = doctorEntity; }

	public PatientEntity getPatientEntity() { return patientEntity; }

	public void setPatientEntity(PatientEntity patientEntity) { this.patientEntity = patientEntity; }
}
