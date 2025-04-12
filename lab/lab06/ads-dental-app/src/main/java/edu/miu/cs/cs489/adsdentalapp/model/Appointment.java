package edu.miu.cs.cs489.adsdentalapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "appointment_no", unique = true, nullable = false)
    private String appointmentNo;

    private String description;

    @Column(name = "value_amount")
    private Double valueAmount;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    @Column(name = "appointment_type")
    private String appointmentType;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;


    public Appointment(String appointmentNo, String description, Double valueAmount, LocalDate appointmentDate,
                       LocalTime appointmentTime, String appointmentType, Patient patient, Dentist dentist, Surgery surgery) {
        this.appointmentNo = appointmentNo;
        this.description = description;
        this.valueAmount = valueAmount;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentType = appointmentType;
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
    }

}
