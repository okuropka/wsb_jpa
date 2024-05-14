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
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // given
        // when
        int testPatientsListSize = patientDao.findByLastName("nazwiskoPacjenta").size();
        // then
        assertEquals(testPatientsListSize, 2);
    }
    
    @Transactional
    @Test
    public void testFindPatientsWithMoreVisitsThan() {
        // given
        int nVisits = 2;
        // when
        List<PatientEntity> testListOfPatientsWithEnoughVisits = patientDao.findPatientsWithMoreVisitsThan(nVisits);
        // then
        assertNotNull(testListOfPatientsWithEnoughVisits);
        assertTrue(testListOfPatientsWithEnoughVisits.get(0).getVisitEntities().size() >= nVisits);
    }

    @Transactional
    @Test
    public void testFindPatientsHigherThan() {
        // given
        int height1 = 169;  // powinien zwrocic 2 pacjentow
        int height2 = 181;  // powinien zwrocic 1 pacjenta
        // when
        List<PatientEntity> testListOfHigherPatients1 = patientDao.findPatientsHigherThan(height1);
        List<PatientEntity> testListOfHigherPatients2 = patientDao.findPatientsHigherThan(height2);
        // then
        assertNotNull(testListOfHigherPatients1);
        assertNotNull(testListOfHigherPatients2);
        assertEquals(2, testListOfHigherPatients1.size());
        assertTrue(testListOfHigherPatients1.get(0).getHeight()>height1);
        assertTrue(testListOfHigherPatients1.get(1).getHeight()>height1);
        assertEquals(1, testListOfHigherPatients1.size());
        assertTrue(testListOfHigherPatients2.get(0).getHeight()>height2);
    }


}

// org.springframework.beans.factory.BeanDefinitionStoreException: Failed to read candidate component class: file [C:\Users\vdi-student\IdeaProjects\wsb_jpa\out\test\wsb_jpa\com\capgemini\wsb\service\PatientServiceTest.class]; nested exception is org.springframework.core.NestedIOException: ASM ClassReader failed to parse class file - probably due to a new Java class file version that isn't supported yet: file [C:\Users\vdi-student\IdeaProjects\wsb_jpa\out\test\wsb_jpa\com\capgemini\wsb\service\PatientServiceTest.class]; nested exception is java.lang.IllegalArgumentException: Unsupported class file major version 61