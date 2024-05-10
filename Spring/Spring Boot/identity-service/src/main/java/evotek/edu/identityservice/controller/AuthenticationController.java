package evotek.edu.identityservice.controller;

import com.nimbusds.jose.JOSEException;
import evotek.edu.identityservice.dto.request.ApiResponse;
import evotek.edu.identityservice.dto.request.AuthenticationRequest;
import evotek.edu.identityservice.dto.request.IntrospectRequest;
import evotek.edu.identityservice.dto.response.AuthenticationResponse;
import evotek.edu.identityservice.dto.response.IntrospectResponse;
import evotek.edu.identityservice.dto.response.UserResponse;
import evotek.edu.identityservice.service.AuthenticationService;
import java.text.ParseException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
//  private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
  AuthenticationService authenticationService;
  @PostMapping("/token")
  ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
    var result = authenticationService.authenticate(request);
//    logger.info("result = " + result);
    return ApiResponse.<AuthenticationResponse>builder()
        .result(result)
        .build();
  }

  @PostMapping("/introspect")
  ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
      throws ParseException, JOSEException {
    var result = authenticationService.introspect(request);
//    logger.info("result = " + result);
    return ApiResponse.<IntrospectResponse>builder()
        .result(result)
        .build();
  }
}
