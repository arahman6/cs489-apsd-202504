package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.PatientMapper;
import edu.miu.cs.cs489.adsdentalapp.model.Address;
import edu.miu.cs.cs489.adsdentalapp.model.Patient;
import edu.miu.cs.cs489.adsdentalapp.repository.AddressRepository;
import edu.miu.cs.cs489.adsdentalapp.repository.PatientRepository;
import edu.miu.cs.cs489.adsdentalapp.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<PatientResponse> getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(patientMapper::toResponse);
    }

    @Override
    public Optional<PatientResponse> addPatient(PatientRequest request) {
        Optional<Address> addressOpt = addressRepository.findById(request.getAddressId());
        if (addressOpt.isPresent()) {
            Patient patient = patientMapper.toEntity(request);
            patient.setAddress(addressOpt.get());
            return Optional.of(patientMapper.toResponse(patientRepository.save(patient)));
        }
        return Optional.empty();
    }

    @Override
    public Optional<PatientResponse> updatePatient(Long id, PatientRequest request) {
        return patientRepository.findById(id).map(existing -> {
            Patient updated = patientMapper.toEntity(request);
            updated.setId(existing.getId());
            if (request.getAddressId() != null) {
                addressRepository.findById(request.getAddressId()).ifPresent(updated::setAddress);
            }
            return patientMapper.toResponse(patientRepository.save(updated));
        });
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        }
    }
}
