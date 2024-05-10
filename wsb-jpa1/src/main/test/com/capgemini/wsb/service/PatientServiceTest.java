package com.capgemini.wsb.service;


import com.capgemini.wsb.service.PatientService;
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
        assertEquals(LocalDate.of(2024,4,5), patientTO.getDateOfBirth());
        assertEquals("333999666", patientTO.getTelephoneNumber());
        assertEquals("inspicjentKowalski@pochtah.pl", patientTO.getEmail());
        assertEquals("12745", patientTO.getPatientNumber());

    }

    @Test
    public void RemovePatient() {
        // given
        PatientTO patientTO = patientService.findById(1L);

        // when
        patientService.removePatient(1L);
        DoctorTO doctorTO = doctorService.findById(1L);

        // then
        assertNull(patientService.findById(1L));
        assertNull(visitService.findById(1L));
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
        assertFalse(patientTO.getVisitTOs().isEmpty()); // czy lista wizyt nie jest pusta?
        assertEquals(2, visitTOs.size()); // czy są dwie wizyty dla tego pacjenta?

    }

    /*
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

        List<VisitTO> visitTOs = new ArrayList<>();
        patientTO.setVisitTOs(visitTOs);

        DoctorTO doctorTO = doctorService.findById(1L);
        /.
        /.
        /.

        // when
        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        // then
        assertNotNull(savedPatientTO.getId());
        assertEquals(patientTO.getFirstName(), savedPatientTO.getFirstName());
        assertEquals(patientTO.getLastName(), savedPatientTO.getLastName());
    }
    */

}
