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
        visitTO.setPatientTO( PatientMapper.mapToTO(visitEntity.getPatientEntity()) );
        visitTO.setDoctorTO( DoctorMapper.mapToTO(visitEntity.getDoctorEntity()) );
        visitTO.setMedicalTreatment( MedicalTreatmentMapper.mapToTO(visitEntity.getMedicalTreatment()) );

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
        visitEntity.setPatientEntity( PatientMapper.mapToEntity(visitTO.getPatientTO()) );
        visitEntity.setDoctorEntity( DoctorMapper.mapToEntity(visitTO.getDoctorTO()) );
        visitEntity.setMedicalTreatment( MedicalTreatmentMapper.mapToEntity(visitTO.getMedicalTreatment()) );

        return visitEntity;
    }
}
