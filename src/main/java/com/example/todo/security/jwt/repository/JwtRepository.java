package com.example.todo.security.jwt.repository;

import com.example.todo.security.jwt.entity.JwtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRepository extends JpaRepository<JwtEntity, Long> {
}
