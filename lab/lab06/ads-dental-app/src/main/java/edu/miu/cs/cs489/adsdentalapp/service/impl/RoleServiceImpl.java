package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.RoleRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.RoleResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.RoleMapper;
import edu.miu.cs.cs489.adsdentalapp.model.Role;
import edu.miu.cs.cs489.adsdentalapp.repository.RoleRepository;
import edu.miu.cs.cs489.adsdentalapp.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepo;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepo.findAll().stream()
                .map(roleMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<RoleResponse> getRoleById(Long id) {
        return roleRepo.findById(id).map(roleMapper::toResponse);
    }

    @Override
    public Optional<RoleResponse> addRole(RoleRequest request) {
        return Optional.of(roleMapper.toResponse(roleRepo.save(roleMapper.toEntity(request))));
    }

    @Override
    public Optional<RoleResponse> updateRole(Long id, RoleRequest request) {
        return roleRepo.findById(id).map(existing -> {
            Role updated = roleMapper.toEntity(request);
            updated.setId(existing.getId());
            return roleMapper.toResponse(roleRepo.save(updated));
        });
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }
}
