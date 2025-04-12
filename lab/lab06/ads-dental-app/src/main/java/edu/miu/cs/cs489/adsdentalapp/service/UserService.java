package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.request.UserRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> getAllUsers();
    Optional<UserResponse> getUserById(Long id);
    Optional<UserResponse> addUser(UserRequest request);
    Optional<UserResponse> updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}
