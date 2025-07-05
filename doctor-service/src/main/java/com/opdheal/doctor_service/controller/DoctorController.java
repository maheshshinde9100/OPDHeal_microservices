package com.opdheal.doctor_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opdheal.doctor_service.service.DoctorService;
import com.opdheal.doctor_service.model.Doctor;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @GetMapping("/u/{id}")
    public Doctor getDoctorInfo(@PathVariable String id){
        return service.getDoctorInfo(id);
    }

    @GetMapping("/u/all")
    public List<Doctor> getAllDoctorInfo(){
        return service.getAllDoctorInfo();
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor){
        return service.addDoctor(doctor);
    }

    @PutMapping("/u/{id}/update")
    public ResponseEntity<?> updateDoctor(@PathVariable String id, @RequestBody Doctor doctor){
        return service.updateDoctor(id,doctor);
    }

    @DeleteMapping("/u/{id}/delete")
    public ResponseEntity<?> deleteDoctor(@PathVariable String id){
        return service.deleteDoctor(id);
    }
}
