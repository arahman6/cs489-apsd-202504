package edu.miu.cs.cs489.adsdentalapp.controller;

import edu.miu.cs.cs489.adsdentalapp.dto.response.AddressResponse;
import edu.miu.cs.cs489.adsdentalapp.service.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
@RequiredArgsConstructor
@Tag(name = "Addresses", description = "Endpoints for managing addresses")
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "Get all addresses", description = "Returns addresses with patients, sorted by city")
    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddressesSortedByCity());
    }
}
