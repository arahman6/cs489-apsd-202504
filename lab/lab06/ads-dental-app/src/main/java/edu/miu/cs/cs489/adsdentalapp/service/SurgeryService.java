package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.request.SurgeryRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.SurgeryResponse;

import java.util.List;
import java.util.Optional;

public interface SurgeryService {
    List<SurgeryResponse> getAllSurgeries();
    Optional<SurgeryResponse> getSurgeryById(Long id);
    Optional<SurgeryResponse> addSurgery(SurgeryRequest request);
    Optional<SurgeryResponse> updateSurgery(Long id, SurgeryRequest request);
    void deleteSurgery(Long id);
}
