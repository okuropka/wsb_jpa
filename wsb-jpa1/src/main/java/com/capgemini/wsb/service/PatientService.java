package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService
{
    PatientTO findById(Long id);
    void removePatient(long id);
    PatientTO addPatient(PatientTO patientTO);
    PatientTO updatePatient(PatientTO patientTO);
    List<VisitTO> getAllVisitsForPatient(Long patientId);
}
