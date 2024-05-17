package com.capgemini.wsb.service;


import com.capgemini.wsb.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private VisitService visitService;

    @Test
    public void FindById() {
        // given
        PatientTO patientTO = patientService.findById(1L);
        // when

        //then
        assertEquals("imiePacjenta", patientTO.getFirstName());
        assertEquals("nazwiskoPacjenta", patientTO.getLastName());
        assertFalse(patientTO.getIsWoman());
        assertEquals(patientTO.getHeight(), 185);
        assertEquals(patientTO.getDateOfBirth(), LocalDate.of(2024,4,5));
        assertEquals("333999666", patientTO.getTelephoneNumber());
        assertEquals("inspicjentKowalski@pochtah.pl", patientTO.getEmail());
        assertEquals("12745", patientTO.getPatientNumber());

    }

    @Test
    public void RemovePatient() {
        // given
        long id = 1L;
        PatientTO patientTO = patientService.findById(id);
        // assertNotNull(patientTO.getId());
        // when
        //patientService.removePatient(patientTO.getId());
        patientService.removePatient(id);   // PUBLIC.VISIT FOREIGN KEY(MEDICAL_TREATMENT_ENTITY_ID) REFERENCES PUBLIC.MEDICALTREATMENT(ID)
        DoctorTO doctorTO = doctorService.findById(id);

        // then
        assertNull(patientService.findById(id));
        assertNull(visitService.findById(id));
        assertNull(visitService.findById(2L));
        assertNotNull(doctorTO);

    }

    @Test
    public void GetAllVisitsForPatient(){
        // given
        PatientTO patientTO = patientService.findById(1L);
        // when
        List<VisitTO> visitTOs = patientService.getAllVisitsForPatient(1L);

        // then
        assertFalse(patientTO.getVisitTOs().isEmpty());
        assertEquals(2, visitTOs.size());

    }

    @Test
    public void AddPatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Jane");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("99999");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setIsWoman(true);
        patientTO.setHeight(169);
        List<VisitTO> temp = new ArrayList<>();
        patientTO.setVisitTOs(temp);

        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        assertNotNull(savedPatientTO.getId());
    }
}