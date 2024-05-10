package evotek.edu.identityservice.service;

import evotek.edu.identityservice.dto.request.UserCreationRequest;
import evotek.edu.identityservice.dto.request.UserUpdateRequest;
import evotek.edu.identityservice.dto.response.UserResponse;
import evotek.edu.identityservice.entity.User;
import evotek.edu.identityservice.enums.Role;
import evotek.edu.identityservice.exception.AppException;
import evotek.edu.identityservice.exception.ErrorCode;
import evotek.edu.identityservice.mapper.UserMapper;
import evotek.edu.identityservice.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

  UserRepository userRepository;
  UserMapper userMapper;
  PasswordEncoder passwordEncoder;

  public User createUser(UserCreationRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
//      throw new AppException(ErrorCode.USER_EXISTED);
      throw new RuntimeException("ErrorCode.USER_EXISTED");

    }
    User user = userMapper.toUser(request);
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    HashSet<Role> roles = new HashSet<>();
    roles.add(Role.USER);
    user.setRoles(roles);

    return userRepository.save(user);

  }

  public UserResponse updateUser(String userId, UserUpdateRequest request) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
    userMapper.updateUser(user, request);
    return userMapper.toUserResponse(userRepository.save(user));
  }

  public void deleteUser(String userId) {
    userRepository.deleteById(userId);
  }

  public void deleteUser() {
    userRepository.deleteAll();
  }

  public UserResponse getMyInfo() {
    log.info("Service getMyInfo");
    var context = SecurityContextHolder.getContext();
    String username = context.getAuthentication().getName();
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    return userMapper.toUserResponse(user);
  }


  @PreAuthorize("hasRole('ADMIN')")
  public List<UserResponse> getUsers() {
    log.info("In method get users");
    return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
  }

  //  @PreAuthorize("hasRole('ADMIN')")
  @PostAuthorize("returnObject.username == authentication.name")
  public UserResponse getUser(String id) {
    log.info("In method get users by id");
    return userMapper.toUserResponse(
        userRepository.findById(id)
            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
  }


}
