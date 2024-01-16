package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
