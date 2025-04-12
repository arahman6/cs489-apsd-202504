package edu.miu.cs.cs489.adsdentalapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DentistResponse {
    private Long id;
    private String fullName;
    private String specialization;
    private String email;
    private String phone;
}
