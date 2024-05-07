package com.capgemini.wsb.service;

import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.dto.*;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService = new PatientServiceImpl(new PatientDaoImpl());

    @Test
    public void FindById() {
        PatientTO patientTO = patientService.findById(1L);

        assertEquals("imiePacjenta", patientTO.getFirstName());
        assertEquals("nazwiskoPacjenta", patientTO.getLastName());
    }
    @Test
    public void AddPatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Al");
        patientTO.setLastName("Le Luja");
        patientTO.setTelephoneNumber("126547777");
        patientTO.setEmail("PraiseTheLord@church.com");
        patientTO.setPatientNumber("111");
        patientTO.setDateOfBirth(LocalDate.of(1960, 12, 12));
        patientTO.setIsWoman(false);

        AddressTO addressTO = new AddressTO();
        addressTO.setId(101L);
        patientTO.setAddressTO(addressTO);

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(555L);

        List<VisitTO> visitTOs = new ArrayList<>();
        VisitTO visit = new VisitTO();

        List<MedicalTreatmentTO> medicalTreatmentTOs = new ArrayList<>();
        MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTOs.add(medicalTreatmentTO);

        visit.setId(111L);
        visit.setPatientTO(patientTO);
        visit.setDoctorTO(doctorTO);
        visit.setMedicalTreatments(medicalTreatmentTOs);
        visitTOs.add(visit);

        patientTO.setVisitTOs(visitTOs);

        // when
        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        // then
        assertNotNull(savedPatientTO.getId());
        assertEquals(patientTO.getFirstName(), savedPatientTO.getFirstName());
        assertEquals(patientTO.getLastName(), savedPatientTO.getLastName());
    }

    @Test
    public void RemovePatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Al");
        patientTO.setLastName("Le Luja");
        patientTO.setTelephoneNumber("126547777");
        patientTO.setEmail("PraiseTheLord@church.com");
        patientTO.setPatientNumber("111");
        patientTO.setDateOfBirth(LocalDate.of(1960, 12, 12));
        patientTO.setIsWoman(false);

        AddressTO addressTO = new AddressTO();
        addressTO.setId(101L);
        patientTO.setAddressTO(addressTO);

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(555L);

        List<VisitTO> visitTOs = new ArrayList<>();
        VisitTO visit = new VisitTO();

        List<MedicalTreatmentTO> medicalTreatmentTOs = new ArrayList<>();
        MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTOs.add(medicalTreatmentTO);

        visit.setId(111L);
        visit.setPatientTO(patientTO);
        visit.setDoctorTO(doctorTO);
        visit.setMedicalTreatments(medicalTreatmentTOs);
        visitTOs.add(visit);

        patientTO.setVisitTOs(visitTOs);
        PatientTO savedPatientTO = patientService.addPatient(patientTO);
        Long patientId = savedPatientTO.getId();

        // when
        patientService.removePatient(patientId);

        // then
        assertNull(patientService.findById(patientId));
    }

    @Test
    public void GetAllVisitsForPatient(){
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Al");
        patientTO.setLastName("Le Luja");
        patientTO.setTelephoneNumber("126547777");
        patientTO.setEmail("PraiseTheLord@church.com");
        patientTO.setPatientNumber("111");
        patientTO.setDateOfBirth(LocalDate.of(1960, 12, 12));
        patientTO.setIsWoman(false);

        AddressTO addressTO = new AddressTO();
        addressTO.setId(101L);
        patientTO.setAddressTO(addressTO);

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(555L);

        List<VisitTO> visitTOs = new ArrayList<>();
        VisitTO visit = new VisitTO();

        List<MedicalTreatmentTO> medicalTreatmentTOs = new ArrayList<>();
        MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTOs.add(medicalTreatmentTO);

        visit.setId(111L);
        visit.setPatientTO(patientTO);
        visit.setDoctorTO(doctorTO);
        visit.setMedicalTreatments(medicalTreatmentTOs);
        visitTOs.add(visit);

        patientTO.setVisitTOs(visitTOs);
        PatientTO savedPatientTO = patientService.addPatient(patientTO);
        Long patientId = savedPatientTO.getId();

        // when
        List<VisitTO> visits2 = patientService.getAllVisitsForPatient(patientId);

        // then
        assertFalse(visitTOs.isEmpty()); // czy lista wizyt nie jest pusta?
        assertEquals(1, visits2.size()); // czy jest tylko jedna wizyta dla tego pacjenta?

    }

}
