package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Test
    public void testShouldFindPatientsByLastName() {
        // given
        // when
        int testPatientsListSize = patientDao.findByLastName("nazwiskoPacjenta").size();
        // then
        assertEquals(testPatientsListSize, 2);
    }

    @Test
    public void testFindPatientsWithMoreVisitsThan() {
        // given
        int nVisits = 1;
        // when
        // powininen zwrócić jednego pacjenta
        List<PatientEntity> testListOfPatientsWithEnoughVisits = patientDao.findPatientsWithMoreVisitsThan(nVisits);
        // then
        assertNotNull(testListOfPatientsWithEnoughVisits);
        assertTrue(testListOfPatientsWithEnoughVisits.get(0).getVisitEntities().size() > nVisits);
    }

    @Test
    public void testFindPatientsHigherThan() {
        // given
        int height1 = 170;
        int height2 = 169;
        // when
        // powinien zwrocic 1 pacjenta
        List<PatientEntity> testListOfHigherPatients1 = patientDao.findPatientsHigherThan(height1);
        // powinien zwrocic 2 pacjentów
        List<PatientEntity> testListOfHigherPatients2 = patientDao.findPatientsHigherThan(height2);
        // then
        assertNotNull(testListOfHigherPatients1);
        assertEquals(1, testListOfHigherPatients1.size());
        assertTrue(testListOfHigherPatients1.get(0).getHeight()>height1);

        assertNotNull(testListOfHigherPatients2);
        assertEquals(2, testListOfHigherPatients2.size());
        assertTrue(testListOfHigherPatients2.get(0).getHeight()>height2);
        assertTrue(testListOfHigherPatients2.get(1).getHeight()>height2);
    }

}