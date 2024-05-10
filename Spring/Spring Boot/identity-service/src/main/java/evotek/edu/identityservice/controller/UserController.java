package evotek.edu.identityservice.controller;

import evotek.edu.identityservice.dto.request.ApiResponse;
import evotek.edu.identityservice.dto.request.UserCreationRequest;
import evotek.edu.identityservice.dto.request.UserUpdateRequest;
import evotek.edu.identityservice.dto.response.UserResponse;
import evotek.edu.identityservice.entity.User;
import evotek.edu.identityservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
    ApiResponse<User> apiResponse = new ApiResponse();
    apiResponse.setResult(userService.createUser(request));
    return apiResponse;
  }

  @GetMapping
  ApiResponse<List<UserResponse>> getUsers() {
    var authentication = SecurityContextHolder.getContext().getAuthentication();

    log.info("Username: {}", authentication.getName());
    authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

    return ApiResponse.<List<UserResponse>>builder()
        .result(userService.getUsers())
        .build();
  }

  @GetMapping("/{userId}")
  ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
    return ApiResponse.<UserResponse>builder()
        .result(userService.getUser(userId))
        .build();
  }

  @GetMapping("/myInfo")
  ApiResponse<UserResponse> getMyInfo() {
    log.info("Controller getMyInfo");
    return ApiResponse.<UserResponse>builder()
        .result(userService.getMyInfo())
        .build();
  }

  @PutMapping("/{userId}")
  UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
    return userService.updateUser(userId, request);
  }

  @DeleteMapping("/{userId}")
  ApiResponse<String> deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
    return ApiResponse.<String>builder()
        .result("User has been delete")
        .build();
  }

  @DeleteMapping()
  ApiResponse<String> deleteUser() {
    userService.deleteUser();
    return ApiResponse.<String>builder()
        .result("All User has been delete")
        .build();
  }
}
