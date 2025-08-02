package com.opdheal.doctor_service.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.opdheal.doctor_service.model.Doctor;
@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String>{
    
}
