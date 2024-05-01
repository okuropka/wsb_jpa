package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.Collection;
import java.util.List;
import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@Column(name = "DOCTOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//relacja dwukierunkowa
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<VisitEntity> visitEntities;

	// relacja dwukierunkowa
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AddressEntity addressEntity;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String telephoneNumber;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DOCTOR_NUMBER", nullable = false)
	private String doctorNumber;

	@Column(name = "SPECIALIZATION", nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

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

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

}
