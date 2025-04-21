package edu.miu.cs.cs489.adsdentalapp.auth;

import edu.miu.cs.cs489.adsdentalapp.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private Role role; // ADMIN, PATIENT, DENTIST
}

