package edu.miu.cs.cs489.adsdentalapp.service.impl;

import edu.miu.cs.cs489.adsdentalapp.dto.request.UserRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.UserResponse;
import edu.miu.cs.cs489.adsdentalapp.mapper.UserMapper;
import edu.miu.cs.cs489.adsdentalapp.model.User;
import edu.miu.cs.cs489.adsdentalapp.repository.RoleRepository;
import edu.miu.cs.cs489.adsdentalapp.repository.UserRepository;
import edu.miu.cs.cs489.adsdentalapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepo.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<UserResponse> getUserById(Long id) {
        return userRepo.findById(id).map(userMapper::toResponse);
    }

    @Override
    public Optional<UserResponse> addUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        user.setRole(roleRepo.findById(request.getRoleId()).orElse(null));
        return Optional.of(userMapper.toResponse(userRepo.save(user)));
    }

    @Override
    public Optional<UserResponse> updateUser(Long id, UserRequest request) {
        return userRepo.findById(id).map(existing -> {
            User updated = userMapper.toEntity(request);
            updated.setId(existing.getId());
            updated.setRole(roleRepo.findById(request.getRoleId()).orElse(null));
            return userMapper.toResponse(userRepo.save(updated));
        });
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
