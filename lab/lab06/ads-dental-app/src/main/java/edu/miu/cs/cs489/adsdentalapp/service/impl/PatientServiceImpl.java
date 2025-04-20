package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.adsdentalapp.exception.PatientNotFoundException;
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
    public List<PatientResponse> findAllSortedByLastName() {
        return patientRepository.findAllByOrderByLastNameAsc()
                .stream()
                .map(patientMapper::toResponse)
                .toList();
    }

    @Override
    public List<PatientResponse> searchPatients(String searchString) {
        return patientRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPhoneContainingIgnoreCase(
                        searchString, searchString, searchString)
                .stream()
                .map(patientMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<PatientResponse> getPatientById(Long id) {
        return Optional.of(patientRepository.findById(id)
                .map(patientMapper::toResponse)
                .orElseThrow(() -> new PatientNotFoundException(id)));
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
            updated.setAddress(addressRepository.findById(request.getAddressId()).orElse(null));
            return patientMapper.toResponse(patientRepository.save(updated));
        });
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException(id);
        }
        patientRepository.deleteById(id);
    }
}
