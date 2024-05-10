package evotek.edu.identityservice.configuration;

import evotek.edu.identityservice.entity.User;
import evotek.edu.identityservice.enums.Role;
import evotek.edu.identityservice.repository.UserRepository;
import java.util.HashSet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

  PasswordEncoder passwordEncoder;

  @Bean
  ApplicationRunner applicationRunner(UserRepository userRepository){
    return args -> {
      if (userRepository.findByUsername("admin").isEmpty()){
        var roles = new HashSet<Role>();
        roles.add(Role.ADMIN);
        User user = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin"))
            .roles(roles)
            .build();

        userRepository.save(user);
        log.warn("admin user have been create with default password: admin, please changeit");
      }
    };
  }
}
