package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.request.RoleRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.RoleResponse;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleResponse> getAllRoles();
    Optional<RoleResponse> getRoleById(Long id);
    Optional<RoleResponse> addRole(RoleRequest request);
    Optional<RoleResponse> updateRole(Long id, RoleRequest request);
    void deleteRole(Long id);
}
