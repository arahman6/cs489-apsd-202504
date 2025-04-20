package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.request.AppointmentRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.AppointmentResponse;
import edu.miu.cs.cs489.adsdentalapp.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appointments", description = "Endpoints for booking and managing dental appointments")
@RestController
@RequestMapping("/adsweb/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(summary = "Get all appointments", description = "Returns a list of all scheduled dental appointments.")
    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @Operation(summary = "Get appointment by ID", description = "Returns the details of the appointment identified by the provided ID.")
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new appointment", description = "Schedules a new dental appointment with the provided details.")
    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(@RequestBody AppointmentRequest request) {
        return appointmentService.addAppointment(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update appointment by ID", description = "Updates the details of the appointment identified by the provided ID.")
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable Long id, @RequestBody AppointmentRequest request) {
        return appointmentService.updateAppointment(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete appointment by ID", description = "Cancels and deletes the appointment identified by the provided ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
