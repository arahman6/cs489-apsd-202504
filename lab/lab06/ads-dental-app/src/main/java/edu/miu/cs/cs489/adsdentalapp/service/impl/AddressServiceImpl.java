package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.response.AddressResponse;
import edu.miu.cs.cs489.adsdentalapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.PatientMapper;
import edu.miu.cs.cs489.adsdentalapp.model.Address;
import edu.miu.cs.cs489.adsdentalapp.service.AddressService;
import edu.miu.cs.cs489.adsdentalapp.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepo;
    private final PatientMapper patientMapper;

    @Override
    @Transactional
    public List<AddressResponse> getAllAddressesSortedByCity() {
        return addressRepo.findAllByOrderByCityAsc()
                .stream()
                .map(addr -> new AddressResponse(
                        addr.getId(),
                        addr.getStreet(),
                        addr.getCity(),
                        addr.getState(),
                        addr.getZipCode(),
                        addr.getPatients().stream()
                                .map(patientMapper::toResponse)
                                .toList()
                ))
                .toList();
    }
}
