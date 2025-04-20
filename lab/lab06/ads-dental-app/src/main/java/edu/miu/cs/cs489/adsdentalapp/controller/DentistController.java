package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.request.DentistRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.DentistResponse;
import edu.miu.cs.cs489.adsdentalapp.service.DentistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Dentists", description = "Endpoints for managing dentists")
@RestController
@RequestMapping("/adsweb/api/v1/dentists")
@RequiredArgsConstructor
public class DentistController {

    private final DentistService dentistService;

    @Operation(summary = "Get all dentists", description = "Returns a list of all dentists.")
    @GetMapping
    public ResponseEntity<List<DentistResponse>> getAllDentists() {
        return ResponseEntity.ok(dentistService.getAllDentists());
    }

    @Operation(summary = "Get dentist by ID", description = "Returns the details of the dentist identified by the provided ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DentistResponse> getDentistById(@PathVariable Long id) {
        return dentistService.getDentistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new dentist", description = "Adds a new dentist with the provided details.")
    @PostMapping
    public ResponseEntity<DentistResponse> createDentist(@RequestBody DentistRequest request) {
        return dentistService.addDentist(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update dentist by ID", description = "Updates the details of the dentist identified by the provided ID.")
    @PutMapping("/{id}")
    public ResponseEntity<DentistResponse> updateDentist(@PathVariable Long id, @RequestBody DentistRequest request) {
        return dentistService.updateDentist(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete dentist by ID", description = "Deletes the dentist identified by the provided ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDentist(@PathVariable Long id) {
        dentistService.deleteDentist(id);
        return ResponseEntity.noContent().build();
    }
}
