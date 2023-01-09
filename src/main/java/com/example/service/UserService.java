package com.example.service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.ResponseDto;
import com.example.dto.SignInDto;
import com.example.dto.SignInResponseDto;
import com.example.dto.SignUpDto;
import com.example.exceptions.AuthenticationFailException;
import com.example.exceptions.CustomException;
import com.example.model.AuthToken;
import com.example.model.User;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AuthService authService;

  @Transactional
  public ResponseDto signUp(SignUpDto signupDto) {
    // check if user is already present
    if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
      // we have an user
      throw new CustomException("user already present");
    }

    // hash the password

    String encryptedpassword = signupDto.getPassword();

    try {
      encryptedpassword = hashPassword(signupDto.getPassword());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    User user = new User(signupDto.getName(),
        signupDto.getEmail(), encryptedpassword);

    userRepository.save(user);

    // save the user

    // create the token

    final AuthToken authenticationToken = new AuthToken(user);

    authService.saveConfirmationToken(authenticationToken);

    ResponseDto responseDto = new ResponseDto("success", "user created succesfully");
    return responseDto;
  }

  private String hashPassword(String password) throws NoSuchAlgorithmException {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hash = passwordEncoder.encode(password);
    // MessageDigest md = MessageDigest.getInstance("MD5");
    // md.update(password.getBytes());
    // byte[] digest = md.digest();
    // String hash = DatatypeConverter
    // .printHexBinary(digest).toUpperCase();
    return hash;
  }

  public SignInResponseDto signIn(SignInDto signInDto) {
    // find user by email

    User user = userRepository.findByEmail(signInDto.getEmail());

    if (Objects.isNull(user)) {
      throw new AuthenticationFailException("user is not valid");
    }

    // verify password
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    if (!passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
      throw new AuthenticationFailException("wrong password");
    }

    // compare the password in DB

    // if password match

    AuthToken token = authService.getToken(user);

    // retrive the token

    if (Objects.isNull(token)) {
      throw new CustomException("token is not present");
    }

    return new SignInResponseDto("success", token.getToken());

    // return response
  }
}
