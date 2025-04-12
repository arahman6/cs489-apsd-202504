package edu.miu.cs.cs489.adsdentalapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientResponse {
    private Long id;
    private String patientNo;
    private String fullName;
    private String phone;
    private String address; // formatted address (optional)
}
