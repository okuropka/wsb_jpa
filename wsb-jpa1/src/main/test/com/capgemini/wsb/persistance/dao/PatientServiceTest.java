package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.VisitService;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import com.capgemini.wsb.service.impl.VisitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientDao patientDao;
    private final PatientService patientService = new PatientServiceImpl(patientDao);
    private VisitService visitService = new VisitServiceImpl();
    private PatientMapper patientMapper;
    private VisitMapper visitMapper;
    private VisitEntity visitEntity;
    private DoctorEntity doctorEntity;
//----------------------------------------------------------------------------------------------------------------------
    @Transactional
    @Test
    public void testShouldRemovePatientAndVisitsButNotDoctor() {
        // given
        Long id = 1L;
        // when
        PatientTO patientTO = patientService.findById(id);
        PatientEntity patientEntity = patientMapper.mapToEntity(patientTO);
        VisitTO visitTO = visitService.findById(id);
        VisitEntity visitEntity = visitMapper.mapToEntity(visitTO);
        // then
        assertThat(patientEntity).isNotNull();
        patientService.removePatientEntity(id);
        assertThat(patientEntity).isNull();
        assertThat().isNull();
    }
//----------------------------------------------------------------------------------------------------------------------
    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");
        long entitiesNumBefore = addressDao.count();

        // when
        final AddressEntity saved = addressDao.save(addressEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore+1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");

        // when
        final AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();
        final AddressEntity newSaved = addressDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        addressDao.delete(saved.getId());

        // then
        final AddressEntity removed = addressDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }


}
