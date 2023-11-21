package com.br.exemplo.jwt.testejwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.exemplo.jwt.testejwt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

