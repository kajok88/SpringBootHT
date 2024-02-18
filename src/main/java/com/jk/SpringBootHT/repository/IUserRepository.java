package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
