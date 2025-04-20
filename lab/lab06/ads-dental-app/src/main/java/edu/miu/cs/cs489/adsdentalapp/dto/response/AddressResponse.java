package edu.miu.cs.cs489.adsdentalapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private List<PatientResponse> patients;
}
