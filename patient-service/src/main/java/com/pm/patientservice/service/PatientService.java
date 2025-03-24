package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.grpc.BillingServiceGrpcClient;
import com.pm.patientservice.kafka.KafkaProducer;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.modal.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

  private final   PatientRepository patientRepository;
  private final BillingServiceGrpcClient billingServiceGrpcClient;
  private final KafkaProducer kafkaProducer;

    public PatientService(PatientRepository patientRepository, BillingServiceGrpcClient billingServiceGrpcClient,
                          KafkaProducer kafkaProducer) {
this.patientRepository = patientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }

    public List<PatientResponseDTO> getPatients() {
    List<Patient> patients = patientRepository.findAll();
    List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A Patient with email already exists"+patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModal(patientRequestDTO));
        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(),newPatient.getName(), newPatient.getEmail());
kafkaProducer.sendEvent(newPatient);
        return PatientMapper.toDTO(newPatient);

    }

    public PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO) {


        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("patient not found with id"+id));
        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)) {
            throw new EmailAlreadyExistsException("A Patient with email already exists"+patientRequestDTO.getEmail());
        }
patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

Patient updatePatient=patientRepository.save(patient);
return PatientMapper.toDTO(updatePatient);
    }


    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}
