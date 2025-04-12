package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.request.SurgeryRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.SurgeryResponse;
import edu.miu.cs.cs489.adsdentalapp.service.SurgeryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Surgeries", description = "Endpoints for managing dental surgery locations")
@RestController
@RequestMapping("/api/surgeries")
@RequiredArgsConstructor
public class SurgeryController {

    private final SurgeryService surgeryService;

    @GetMapping
    public ResponseEntity<List<SurgeryResponse>> getAllSurgeries() {
        return ResponseEntity.ok(surgeryService.getAllSurgeries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurgeryResponse> getSurgeryById(@PathVariable Long id) {
        return surgeryService.getSurgeryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SurgeryResponse> createSurgery(@RequestBody SurgeryRequest request) {
        return surgeryService.addSurgery(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurgeryResponse> updateSurgery(@PathVariable Long id, @RequestBody SurgeryRequest request) {
        return surgeryService.updateSurgery(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteSurgery(id);
        return ResponseEntity.noContent().build();
    }
}
