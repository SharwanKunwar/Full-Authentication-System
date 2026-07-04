package com.unpredictableXcoders.BackendApplication.login.repositories;

import com.unpredictableXcoders.BackendApplication.login.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
