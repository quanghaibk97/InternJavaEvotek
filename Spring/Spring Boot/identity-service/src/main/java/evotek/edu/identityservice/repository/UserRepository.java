package evotek.edu.identityservice.repository;

import evotek.edu.identityservice.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  boolean existsByUsername(String username);
//  @Query("select u from User u where u.username = :username")
  Optional<User> findByUsername(String username);
}
