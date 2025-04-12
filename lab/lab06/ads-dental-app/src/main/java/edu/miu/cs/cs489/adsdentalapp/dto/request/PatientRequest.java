package edu.miu.cs.cs489.adsdentalapp.dto.request;

import lombok.Data;

@Data
public class PatientRequest {
    private String patientNo;
    private String firstName;
    private String lastName;
    private String phone;
    private Long addressId;
}
