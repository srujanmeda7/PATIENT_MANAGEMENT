package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.modal.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {

    PatientResponseDTO patientDTO = new PatientResponseDTO();
    patientDTO.setId(patient.getId().toString());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
    patientDTO.setName(patient.getName());
patientDTO.setEmail(patient.getEmail());
return patientDTO;
    }
    public static Patient toModal(PatientRequestDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmail(patientDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientDTO.getDateOfBirth()));
        return patient;
    }
}
