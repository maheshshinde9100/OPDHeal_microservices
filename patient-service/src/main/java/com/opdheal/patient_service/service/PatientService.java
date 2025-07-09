package com.opdheal.patient_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opdheal.patient_service.model.Patient;
import com.opdheal.patient_service.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    public Patient getPatient(String patientId){
        return repo.findById(patientId).orElse(null);
    }

    public List<Patient> getAllPatient(){
        return repo.findAll();
    }

    public void savePatient(Patient patient){
        repo.save(patient);
    }

    public boolean updatePatient(String patientId,Patient newPatient){
        Patient oldPatient = repo.findById(patientId);
        oldPatient.setPatientName(newPatient.getPatientName());
        oldPatient.setGender(newPatient.getGender());
        oldPatient.setAge(newPatient.getAge());
        oldPatient.setCity(newPatient.getCity());
        oldPatient.setDob(newPatient.getDob());
        oldPatient.setMedicalIssue(newPatient.getMedicalIssue());
        oldPatient.setPinCode(newPatient.getPinCode());
        return true;
    }
}
