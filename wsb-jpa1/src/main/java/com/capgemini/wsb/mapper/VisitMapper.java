package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.BasicDoctorTO;
import com.capgemini.wsb.dto.BasicPatientTO;
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

        BasicPatientTO tempPat = new BasicPatientTO();
        tempPat.setId(visitEntity.getPatientEntity().getId());
        tempPat.setFirstName(visitEntity.getPatientEntity().getFirstName());
        tempPat.setLastName(visitEntity.getPatientEntity().getLastName());
        visitTO.setBasicPatientTO(tempPat);
        //visitTO.setPatientTO( PatientMapper.mapToTO(visitEntity.getPatientEntity()) );

        BasicDoctorTO tempDoc = new BasicDoctorTO();
        tempDoc.setId(visitEntity.getDoctorEntity().getId());
        tempDoc.setFirstName(visitEntity.getDoctorEntity().getFirstName());
        tempDoc.setLastName(visitEntity.getDoctorEntity().getLastName());
        visitTO.setBasicDoctorTO(tempDoc);
        //visitTO.setDoctorTO( DoctorMapper.mapToTO(visitEntity.getDoctorEntity()) );

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

        PatientEntity tempPat = new PatientEntity();
        tempPat.setId(visitTO.getBasicPatientTO().getId());
        tempPat.setFirstName(visitTO.getBasicPatientTO().getFirstName());
        tempPat.setLastName(visitTO.getBasicPatientTO().getLastName());
        visitEntity.setPatientEntity(tempPat);
        //visitEntity.setPatientEntity( PatientMapper.mapToEntity(visitTO.getPatientTO()) );

        DoctorEntity tempDoc = new DoctorEntity();
        tempDoc.setId(visitTO.getBasicDoctorTO().getId());
        tempDoc.setFirstName(visitTO.getBasicDoctorTO().getFirstName());
        tempDoc.setLastName(visitTO.getBasicDoctorTO().getLastName());
        visitEntity.setDoctorEntity(tempDoc);
        //visitEntity.setDoctorEntity( DoctorMapper.mapToEntity(visitTO.getDoctorTO()) );

        visitEntity.setMedicalTreatment( MedicalTreatmentMapper.mapToEntity(visitTO.getMedicalTreatment()) );

        return visitEntity;
    }
}
