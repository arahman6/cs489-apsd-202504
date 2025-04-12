package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.request.AppointmentRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.AppointmentResponse;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<AppointmentResponse> getAllAppointments();
    Optional<AppointmentResponse> getAppointmentById(Long id);
    Optional<AppointmentResponse> addAppointment(AppointmentRequest request);
    Optional<AppointmentResponse> updateAppointment(Long id, AppointmentRequest request);
    void deleteAppointment(Long id);
}
