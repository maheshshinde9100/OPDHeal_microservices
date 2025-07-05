package com.opdheal.doctor_service.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    private String doctorId;
    private String firstName;
    private String lastName;
    private String specialization;

    @Temporal(TemporalType.DATE)
    // @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dob;

    private long mobileNo;
    private String email;
    private String city;
    private int pinCode;
}
