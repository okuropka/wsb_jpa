package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.*;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testFindById() {
        PatientTO patientTO = patientService.findById(1L);

        assertEquals("imiePacjenta", patientTO.getFirstName());
        assertEquals("nazwiskoPacjenta", patientTO.getLastName());
    }
    @Test
    public void testAddPatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Al");
        patientTO.setLastName("Le Luja");
        patientTO.setTelephoneNumber("126547777");
        patientTO.setEmail("PraiseThe@Lord.com");
        patientTO.setPatientNumber("111");
        patientTO.setDateOfBirth(LocalDate.of(1960, 12, 12));
        patientTO.setIsWoman(false);

        // when
        PatientTO savedPatientTO = patientService.addPatient(patientTO);

        // then
        assertNotNull(savedPatientTO.getId());
        assertEquals(patientTO.getFirstName(), savedPatientTO.getFirstName());
        assertEquals(patientTO.getLastName(), savedPatientTO.getLastName());
    }

    @Test
    public void testRemovePatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Al");
        patientTO.setLastName("Le Luja");
        patientTO.setTelephoneNumber("126547777");
        patientTO.setEmail("PraiseThe@Lord.com");
        patientTO.setPatientNumber("111");
        patientTO.setDateOfBirth(LocalDate.of(1960, 12, 12));
        patientTO.setIsWoman(false);

        PatientTO savedPatientTO = patientService.addPatient(patientTO);
        Long patientId = savedPatientTO.getId();

        // when
        patientService.removePatient(patientId);

        // then
        assertNull(patientService.findById(patientId));
    }

    @Test
    public void testGetAllVisitsForPatient(){
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("Al");
        patientTO.setLastName("Le Luja");
        patientTO.setTelephoneNumber("126547777");
        patientTO.setEmail("PraiseThe@Lord.com");
        patientTO.setPatientNumber("111");
        patientTO.setDateOfBirth(LocalDate.of(1960, 12, 12));
        patientTO.setIsWoman(false);

        PatientTO savedPatientTO = patientService.addPatient(patientTO);
        Long patientId = savedPatientTO.getId();

        AddressTO addressTO = new AddressTO();
        addressTO.setId(101L);

        patientTO.setAddressTO(addressTO);

        List<VisitTO> visitTOs = new ArrayList<>();
        VisitTO visit = new VisitTO();
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(500L);
        visit.setId(101L);
        visit.setPatientId(patientTO.getId());
        visit.setDoctorId(doctorTO.getId());
        visitTOs.add(visit);

        patientTO.setVisitTOs(visitTOs);
        // when
        List<VisitTO> visits2 = patientService.getAllVisitsForPatient(patientId);

        // then
        assertFalse(visitTOs.isEmpty()); // czy lista wizyt nie jest pusta?
        assertEquals(1, visits2.size()); // czy jest tylko jedna wizyta dla tego pacjenta?

    }

}
