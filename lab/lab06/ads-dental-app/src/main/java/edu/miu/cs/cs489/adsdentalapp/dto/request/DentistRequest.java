package edu.miu.cs.cs489.adsdentalapp.dto.request;

import lombok.Data;

@Data
public class DentistRequest {
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
    private String phone;
}
