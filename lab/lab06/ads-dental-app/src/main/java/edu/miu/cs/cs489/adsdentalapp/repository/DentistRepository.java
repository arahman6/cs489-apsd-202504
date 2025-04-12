package edu.miu.cs.cs489.adsdentalapp.repository;

import edu.miu.cs.cs489.adsdentalapp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
