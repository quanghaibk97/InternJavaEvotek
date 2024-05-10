package evotek.edu.identityservice.mapper;

import ch.qos.logback.core.model.ComponentModel;
import evotek.edu.identityservice.dto.request.UserCreationRequest;
import evotek.edu.identityservice.dto.request.UserUpdateRequest;
import evotek.edu.identityservice.dto.response.UserResponse;
import evotek.edu.identityservice.entity.User;
import java.awt.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toUser(UserCreationRequest request);

//  @Mapping(source = "firstName", target = "lastName")
  @Mapping(target = "lastName",ignore = true)
  UserResponse toUserResponse(User user);
  void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
