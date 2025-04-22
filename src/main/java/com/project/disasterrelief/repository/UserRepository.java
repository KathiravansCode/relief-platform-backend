package com.project.disasterrelief.repository;

import com.project.disasterrelief.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username = :usernameOrEmail OR u.email = :usernameOrEmail")
    public Optional<User> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);;

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
