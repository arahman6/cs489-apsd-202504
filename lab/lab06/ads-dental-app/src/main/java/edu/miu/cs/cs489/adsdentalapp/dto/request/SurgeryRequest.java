package edu.miu.cs.cs489.adsdentalapp.dto.request;

import lombok.Data;

@Data
public class SurgeryRequest {
    private String surgeryNo;
    private String name;
    private Long addressId;
}
