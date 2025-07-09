package com.opdheal.patient_service.repository;

import org.springframework.stereotype.Repository;
import org.springframework.mongodb.repository.MongoRepository;
import com.opdheal.patient_service.model.*;
@Repository
public interface PatientRepository extends MongoRepository<Patient,String> {
    
}
