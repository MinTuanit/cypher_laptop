package com.example.cypher_laptop.repository.auth;

import com.example.cypher_laptop.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
