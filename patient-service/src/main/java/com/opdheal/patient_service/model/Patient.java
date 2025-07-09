package com.opdheal.patient_service.model;
import java.sql.Date;
import lombok.*;

@Data
@Document(collection="patients")
public class Patient {
    @Id
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
    private Date dob;
    private String medicalIssue;
    private String city;
    private int pinCode;
}
