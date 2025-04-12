package edu.miu.cs.cs489.adsdentalapp.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientResponse {
    @Schema(description = "Unique identifier of the patient")
    private Long id;
    private String patientNo;
    @Schema(description = "Patient's full name")
    private String fullName;
    private String phone;
    private String address; // formatted address (optional)
}
