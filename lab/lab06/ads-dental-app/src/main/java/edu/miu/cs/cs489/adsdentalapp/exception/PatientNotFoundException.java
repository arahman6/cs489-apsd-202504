package edu.miu.cs.cs489.adsdentalapp.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Patient with ID " + id + " not found.");
    }
}
