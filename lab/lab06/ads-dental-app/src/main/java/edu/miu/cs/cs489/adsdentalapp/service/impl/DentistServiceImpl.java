package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.DentistRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.DentistResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.DentistMapper;
import edu.miu.cs.cs489.adsdentalapp.model.Dentist;
import edu.miu.cs.cs489.adsdentalapp.repository.DentistRepository;
import edu.miu.cs.cs489.adsdentalapp.service.DentistService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepo;
    private final DentistMapper dentistMapper;

    @Override
    public List<DentistResponse> getAllDentists() {
        return dentistRepo.findAll().stream()
                .map(dentistMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<DentistResponse> getDentistById(Long id) {
        return dentistRepo.findById(id)
                .map(dentistMapper::toResponse);
    }

    @Override
    public Optional<DentistResponse> addDentist(DentistRequest request) {
        Dentist saved = dentistRepo.save(dentistMapper.toEntity(request));
        return Optional.of(dentistMapper.toResponse(saved));
    }

    @Override
    public Optional<DentistResponse> updateDentist(Long id, DentistRequest request) {
        return dentistRepo.findById(id).map(existing -> {
            Dentist updated = dentistMapper.toEntity(request);
            updated.setId(existing.getId());
            return dentistMapper.toResponse(dentistRepo.save(updated));
        });
    }

    @Override
    @Transactional
    public void deleteDentist(Long id) {
        dentistRepo.deleteById(id);
    }
}
