package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.VisitService;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientDao patientDao = new PatientDaoImpl();
    private VisitDao visitDao;
    private final PatientService patientService = new PatientServiceImpl(patientDao);
    private VisitService visitService;
    private PatientMapper patientMapper;
    private VisitMapper visitMapper;
    private VisitEntity visitEntity;
//----------------------------------------------------------------------------------------------------------------------
    @Transactional
    @Test
    public void testShouldRemovePatientAndVisitsButNotDoctor() {
        // given
        Long id = 1L;
        // when
        /*
        PatientTO patientTO = patientService.findById(id);
        PatientEntity patientEntity = patientMapper.mapToEntity(patientTO);
        VisitTO visitTO = visitService.findById(id);
        VisitEntity visitEntity = visitMapper.mapToEntity(visitTO);
        */
        // then
        assertThat(patientDao).isNotNull();
        patientService.removePatientEntity(id);
        assertThat(visitDao).isNull();
        assertThat(patientDao).isNull();
    }
//----------------------------------------------------------------------------------------------------------------------
    @Transactional
    @Test
    public void testLoadPatientAndShowStructure(){
        // given
        Long id = 1L;
        // when

        // then

    }

}
