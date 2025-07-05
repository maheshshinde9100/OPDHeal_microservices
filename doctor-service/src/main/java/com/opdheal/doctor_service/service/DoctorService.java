package com.opdheal.doctor_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import com.opdheal.doctor_service.model.Doctor;
import com.opdheal.doctor_service.repository.DoctorRepository;
import java.util.*;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

   public Doctor getDoctorInfo(String doctorId) {
    return repo.findAll().stream()
        .filter(doctor -> doctor.getDoctorId().equals(doctorId))
        .findFirst()
        .orElse(null);
    }

    public List<Doctor> getAllDoctorInfo(){
        return repo.findAll();
    }

    //insertt doctor info
    public ResponseEntity<?> addDoctor(Doctor doctor){
        if(doctor==null){
            return new ResponseEntity<>("Invalid details provided",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(repo.save(doctor),HttpStatus.CREATED);
    }

    //delete doctor
    public ResponseEntity<?> deleteDoctor(String doctorId){
        if(doctorId.equals("")){
            return new ResponseEntity<>("Invalid id..",HttpStatus.BAD_REQUEST);
        }
        
        repo.deleteById(doctorId);
        return new ResponseEntity<>("Deleted Succesfully..",HttpStatus.OK);
    }

    //search
    public ResponseEntity<?> findDoctor(String doctorId){
        if(doctorId.equals("")){
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }    
        return new ResponseEntity<>(repo.findById(doctorId),HttpStatus.FOUND);
    }

    //upddate
    public ResponseEntity<?> updateDoctor(String doctorId,Doctor newDoctor){
        if(newDoctor==null){
            return new ResponseEntity<>("Invalid Input Body..",HttpStatus.BAD_REQUEST);
        }
        
        Doctor oldDoctor = getDoctorInfo(doctorId);
        oldDoctor.setFirstName(newDoctor.getFirstName());
        oldDoctor.setLastName(newDoctor.getLastName());

        oldDoctor.setMobileNo(newDoctor.getMobileNo());
        oldDoctor.setEmail(newDoctor.getEmail());

        oldDoctor.setCity(newDoctor.getCity());
        oldDoctor.setPinCode(newDoctor.getPinCode());

        oldDoctor.setSpecialization(newDoctor.getSpecialization());
        oldDoctor.setDob(newDoctor.getDob());

        return new ResponseEntity<>("Updated Doctor Information..",HttpStatus.OK);
    }
}
