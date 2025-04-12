package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.AppointmentRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.AppointmentResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.AppointmentMapper;
import edu.miu.cs.cs489.adsdentalapp.model.Appointment;
import edu.miu.cs.cs489.adsdentalapp.repository.*;
import edu.miu.cs.cs489.adsdentalapp.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepo;
    private final AppointmentMapper appointmentMapper;

    private final PatientRepository patientRepo;
    private final DentistRepository dentistRepo;
    private final SurgeryRepository surgeryRepo;

    @Override
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepo.findAll().stream()
                .map(appointmentMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<AppointmentResponse> getAppointmentById(Long id) {
        return appointmentRepo.findById(id)
                .map(appointmentMapper::toResponse);
    }

    @Override
    public Optional<AppointmentResponse> addAppointment(AppointmentRequest request) {
        Appointment appointment = appointmentMapper.toEntity(request);
        appointment.setPatient(patientRepo.findById(request.getPatientId()).orElse(null));
        appointment.setDentist(dentistRepo.findById(request.getDentistId()).orElse(null));
        appointment.setSurgery(surgeryRepo.findById(request.getSurgeryId()).orElse(null));
        return Optional.of(appointmentMapper.toResponse(appointmentRepo.save(appointment)));
    }

    @Override
    public Optional<AppointmentResponse> updateAppointment(Long id, AppointmentRequest request) {
        return appointmentRepo.findById(id).map(existing -> {
            Appointment updated = appointmentMapper.toEntity(request);
            updated.setId(existing.getId());
            updated.setPatient(patientRepo.findById(request.getPatientId()).orElse(null));
            updated.setDentist(dentistRepo.findById(request.getDentistId()).orElse(null));
            updated.setSurgery(surgeryRepo.findById(request.getSurgeryId()).orElse(null));
            return appointmentMapper.toResponse(appointmentRepo.save(updated));
        });
    }

    @Override
    @Transactional
    public void deleteAppointment(Long id) {
        appointmentRepo.deleteById(id);
    }
}
