package edu.miu.cs.cs489.adsdentalapp.mapper;

import edu.miu.cs.cs489.adsdentalapp.dto.request.UserRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.UserResponse;
import edu.miu.cs.cs489.adsdentalapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roleName", source = "role.roleName")
    UserResponse toResponse(User user);

    User toEntity(UserRequest request);
}
