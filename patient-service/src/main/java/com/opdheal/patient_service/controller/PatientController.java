package com.opdheal.patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opdheal.patient_service.model.Patient;
import com.opdheal.patient_service.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    public Patient getPatient(){
        return service;
    }
}
