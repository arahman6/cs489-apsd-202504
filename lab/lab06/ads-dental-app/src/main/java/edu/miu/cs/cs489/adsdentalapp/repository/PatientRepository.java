package edu.miu.cs.cs489.adsdentalapp.repository;

import edu.miu.cs.cs489.adsdentalapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByOrderByLastNameAsc();
    List<Patient> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPhoneContainingIgnoreCase(
            String firstName,
            String lastName,
            String phone
    );
}

