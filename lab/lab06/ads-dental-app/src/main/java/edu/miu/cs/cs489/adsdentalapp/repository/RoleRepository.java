package edu.miu.cs.cs489.adsdentalapp.repository;

import edu.miu.cs.cs489.adsdentalapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
