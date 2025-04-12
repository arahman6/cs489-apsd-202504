package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.SurgeryRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.SurgeryResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.SurgeryMapper;
import edu.miu.cs.cs489.adsdentalapp.model.Surgery;
import edu.miu.cs.cs489.adsdentalapp.repository.AddressRepository;
import edu.miu.cs.cs489.adsdentalapp.repository.SurgeryRepository;
import edu.miu.cs.cs489.adsdentalapp.service.SurgeryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurgeryServiceImpl implements SurgeryService {

    private final SurgeryRepository surgeryRepo;
    private final AddressRepository addressRepo;
    private final SurgeryMapper surgeryMapper;

    @Override
    public List<SurgeryResponse> getAllSurgeries() {
        return surgeryRepo.findAll().stream()
                .map(surgeryMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<SurgeryResponse> getSurgeryById(Long id) {
        return surgeryRepo.findById(id).map(surgeryMapper::toResponse);
    }

    @Override
    public Optional<SurgeryResponse> addSurgery(SurgeryRequest request) {
        Surgery surgery = surgeryMapper.toEntity(request);
        surgery.setAddress(addressRepo.findById(request.getAddressId()).orElse(null));
        return Optional.of(surgeryMapper.toResponse(surgeryRepo.save(surgery)));
    }

    @Override
    public Optional<SurgeryResponse> updateSurgery(Long id, SurgeryRequest request) {
        return surgeryRepo.findById(id).map(existing -> {
            Surgery updated = surgeryMapper.toEntity(request);
            updated.setId(existing.getId());
            updated.setAddress(addressRepo.findById(request.getAddressId()).orElse(null));
            return surgeryMapper.toResponse(surgeryRepo.save(updated));
        });
    }

    @Override
    @Transactional
    public void deleteSurgery(Long id) {
        surgeryRepo.deleteById(id);
    }
}
