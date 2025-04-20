package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.PatientResponse;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientResponse> getAllPatients();
    List<PatientResponse> findAllSortedByLastName();
    List<PatientResponse> searchPatients(String searchString);

    Optional<PatientResponse> getPatientById(Long id);
    Optional<PatientResponse> addPatient(PatientRequest request);
    Optional<PatientResponse> updatePatient(Long id, PatientRequest request);
    void deletePatient(Long id);
}
