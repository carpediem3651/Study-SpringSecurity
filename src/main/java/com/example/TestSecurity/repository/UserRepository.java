package com.example.TestSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TestSecurity.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}
