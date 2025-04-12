package edu.miu.cs.cs489.adsdentalapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurgeryResponse {
    private Long id;
    private String surgeryNo;
    private String name;
    private String address;
}
