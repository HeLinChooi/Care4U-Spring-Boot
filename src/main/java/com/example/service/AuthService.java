package com.example.service;

/**
 * AuthService
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AuthToken;
import com.example.model.User;
import com.example.repository.TokenRepository;

@Service
public class AuthService {

    @Autowired
    TokenRepository tokenRepository;

    public void saveConfirmationToken(AuthToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
