package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.adsdentalapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.adsdentalapp.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Patients", description = "Endpoints for managing patients")
@RestController
@RequestMapping("/adsweb/api/v1/patients")
@RequiredArgsConstructor

public class PatientController {

    private final PatientService patientService;

    @Operation(summary = "Get all patients", description = "Returns all patients sorted by last name ascending.")
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatientsSorted() {
        return ResponseEntity.ok(patientService.findAllSortedByLastName());
    }


    @Operation(summary = "Get patient by ID", description = "Returns a single patient by their ID.")
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id).get());
    }

    @Operation(summary = "Search patients", description = "Search patients by name or phone")
    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatients(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatients(searchString));
    }


    @Operation(summary = "Create a new patient", description = "Registers a new patient with the provided details.")
    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest request) {
        return patientService.addPatient(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update patient", description = "Updates the patient with given ID")
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequest request) {
        return patientService.updatePatient(id, request)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    @Operation(summary = "Delete patient by ID", description = "Deletes the patient identified by the provided ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
