package edu.miu.cs.cs489.adsdentalapp.mapper;

import edu.miu.cs.cs489.adsdentalapp.dto.request.RoleRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.RoleResponse;
import edu.miu.cs.cs489.adsdentalapp.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse toResponse(Role role);
    Role toEntity(RoleRequest request);
}
