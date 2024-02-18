package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String username);
}
