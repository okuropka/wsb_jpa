package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findPatientsWithMoreVisitsThan(int nVisits);

    List<PatientEntity> findPatientsHigherThan(int height);
}
