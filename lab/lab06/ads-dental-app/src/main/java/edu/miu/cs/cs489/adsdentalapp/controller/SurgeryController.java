package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.request.SurgeryRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.SurgeryResponse;
import edu.miu.cs.cs489.adsdentalapp.service.SurgeryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Surgeries", description = "Endpoints for managing dental surgery locations")
@RestController
@RequestMapping("/adsweb/api/v1/surgeries")
@RequiredArgsConstructor
public class SurgeryController {

    private final SurgeryService surgeryService;

    @Operation(summary = "Get all surgeries", description = "Returns a list of all dental surgery locations.")
    @GetMapping
    public ResponseEntity<List<SurgeryResponse>> getAllSurgeries() {
        return ResponseEntity.ok(surgeryService.getAllSurgeries());
    }

    @Operation(summary = "Get surgery by ID", description = "Returns the details of the surgery identified by the provided ID.")
    @GetMapping("/{id}")
    public ResponseEntity<SurgeryResponse> getSurgeryById(@PathVariable Long id) {
        return surgeryService.getSurgeryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new surgery", description = "Creates a new dental surgery location with the provided details.")
    @PostMapping
    public ResponseEntity<SurgeryResponse> createSurgery(@RequestBody SurgeryRequest request) {
        return surgeryService.addSurgery(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Update surgery by ID", description = "Updates the details of the surgery identified by the provided ID.")
    @PutMapping("/{id}")
    public ResponseEntity<SurgeryResponse> updateSurgery(@PathVariable Long id, @RequestBody SurgeryRequest request) {
        return surgeryService.updateSurgery(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete surgery by ID", description = "Deletes the surgery identified by the provided ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteSurgery(id);
        return ResponseEntity.noContent().build();
    }
}
