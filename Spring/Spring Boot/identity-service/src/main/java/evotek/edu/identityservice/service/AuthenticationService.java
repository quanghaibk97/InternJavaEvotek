package evotek.edu.identityservice.service;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import evotek.edu.identityservice.dto.request.AuthenticationRequest;
import evotek.edu.identityservice.dto.request.IntrospectRequest;
import evotek.edu.identityservice.dto.response.AuthenticationResponse;
import evotek.edu.identityservice.dto.response.IntrospectResponse;
import evotek.edu.identityservice.dto.response.UserResponse;
import evotek.edu.identityservice.entity.User;
import evotek.edu.identityservice.enums.Role;
import evotek.edu.identityservice.exception.AppException;
import evotek.edu.identityservice.exception.ErrorCode;
import evotek.edu.identityservice.mapper.UserMapper;
import evotek.edu.identityservice.repository.UserRepository;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {


  UserRepository userRepository;
  @NonFinal
  @Value("${jwt.signerKey}")
  protected String SIGNER_KEY;

  public IntrospectResponse introspect(IntrospectRequest request)
      throws JOSEException, ParseException {
    var token = request.getToken();

    JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
    SignedJWT signedJWT = SignedJWT.parse(token);
    Date expirytime = signedJWT.getJWTClaimsSet().getExpirationTime();
    var verified = signedJWT.verify(verifier);

    return IntrospectResponse.builder()
        .valid(verified && expirytime.after(new Date()))
        .build();
  }


  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    var user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

    if (!authenticated) {
      throw new AppException(ErrorCode.UNAUTHENTICATED);
    }
    var token = generateToken(user);
    return AuthenticationResponse.builder()
        .token(token)
        .authenticated(true)
        .build();
  }

  private String generateToken(User user) {
    JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

    JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
        .subject(user.getUsername())
        .issuer("Evotek.edu")
        .issueTime(new Date())
        .expirationTime(new Date(
            Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
        ))
        .claim("scope", builtScope(user))
        .build();
    Payload payload = new Payload(jwtClaimsSet.toJSONObject());
    JWSObject jwsObject = new JWSObject(header, payload);

    try {
      jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
      return jwsObject.serialize();
    } catch (JOSEException e){
      log.error("Cannot create token", e);
      throw new RuntimeException(e);
    }
  }

  private String builtScope(User user){
    StringJoiner stringJoiner = new StringJoiner(" ");
//    Set<Role> roles = user.getRoles();
//    for (Role role : roles) {
//      stringJoiner.add(role.toString());
//    }
    user.getRoles().forEach(role -> stringJoiner.add(role.toString()));
    return stringJoiner.toString();
  }

}