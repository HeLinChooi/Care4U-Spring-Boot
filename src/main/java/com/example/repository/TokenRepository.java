package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.AuthToken;
import com.example.model.User;

public interface TokenRepository extends JpaRepository<AuthToken, Long>{
  AuthToken findByUser(User user);
}
