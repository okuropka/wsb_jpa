package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {
        // given
        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getLastName()).isEqualTo("nazwiskoPacjenta");
    }
    
    @Transactional
    @Test
    public void testFindPatientsWithMoreVisitsThan() {
        // given

        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        // then

    }

    @Transactional
    @Test
    public void testFindFemalePatients() {
        // given

        // when
        PatientEntity patientEntity = patientDao.findOne(1L);
        // then

    }


}
