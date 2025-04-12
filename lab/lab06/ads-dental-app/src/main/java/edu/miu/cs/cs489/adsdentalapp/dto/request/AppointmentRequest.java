package edu.miu.cs.cs489.adsdentalapp.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequest {
    private String appointmentNo;
    private String description;
    private Double valueAmount;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String appointmentType;
    private Long patientId;
    private Long dentistId;
    private Long surgeryId;
}
