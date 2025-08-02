package com.opdheal.doctor_service.model;

import lombok.*;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="doctors")
public class Doctor {
    // @Id
    private String doctorId;
    private String firstName;
    private String lastName;
    private String specialization;

    // @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dob;
    private long mobileNo;
    private String email;
    private String city;
    private int pinCode;
}
