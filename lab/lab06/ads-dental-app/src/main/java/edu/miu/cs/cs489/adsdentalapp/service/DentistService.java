package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.request.DentistRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.DentistResponse;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    List<DentistResponse> getAllDentists();
    Optional<DentistResponse> getDentistById(Long id);
    Optional<DentistResponse> addDentist(DentistRequest request);
    Optional<DentistResponse> updateDentist(Long id, DentistRequest request);
    void deleteDentist(Long id);
}
