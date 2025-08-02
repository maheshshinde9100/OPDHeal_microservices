package com.opdheal.doctor_service.dto;
import lombok.*;
@Data
public class DoctorResponse{
    private long mobileNo;
    private String email;
    private String city;
    private int pinCode;
}