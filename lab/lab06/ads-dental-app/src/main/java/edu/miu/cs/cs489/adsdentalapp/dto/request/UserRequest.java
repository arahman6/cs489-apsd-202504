package edu.miu.cs.cs489.adsdentalapp.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private Long roleId;
}
