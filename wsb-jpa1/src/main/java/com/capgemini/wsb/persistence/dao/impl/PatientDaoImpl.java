package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public List<PatientEntity> findByLastName(String lastName){
        return entityManager.createQuery("select patient from PatientEntity patientEntity where patient.lastName like :lastName", PatientEntity.class )
                            .setParameter("lastName", lastName)
                            .getResultList();
    }

    public List<PatientEntity> findPatientsWithMoreVisitsThan(int nVisits){
        return entityManager.createQuery("select patient from PatientEntity patientEntity where size(patientEntity.visitEntities > :numVisits", PatientEntity.class)
                            .setParameter("numVisits", nVisits)
                            .getResultList();
    }

    public List<PatientEntity> findPatientsHigherThan(int height){
        return entityManager.createQuery("select patient from PatientEntity patientEntity where patient.height > :h", PatientEntity.class)
                .setParameter("h", height)
                .getResultList();
    }
}
