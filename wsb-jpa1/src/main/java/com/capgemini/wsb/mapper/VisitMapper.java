package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public final class VisitMapper
{

    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setPatientId(visitEntity.getPatient().getId());
        visitTO.setDoctorId(visitEntity.getDoctor().getId());
        visitTO.setMedicalTreatments(visitEntity.getMedicalTreatments().stream().map(MedicalTreatmentMapper::mapToTO).collect(Collectors.toList()));

        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO)
    {
        if(visitTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setMedicalTreatments(visitTO.getMedicalTreatments().stream().map(MedicalTreatmentMapper::mapToEntity).collect(Collectors.toList()));

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(visitTO.getPatientId());
        visitEntity.setPatient(patientEntity);

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(visitTO.getDoctorId());
        visitEntity.setDoctor(doctorEntity);

        return visitEntity;
    }
}
