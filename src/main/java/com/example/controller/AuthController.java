package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseDto;
import com.example.dto.SignInDto;
import com.example.dto.SignInResponseDto;
import com.example.dto.SignUpDto;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = { "http://localhost:3000", "https://care4u.vercel.app/" })
public class AuthController {

  @Autowired
  UserService userService;

  // signup
  @PostMapping("/signup")
  public ResponseDto signup(@RequestBody SignUpDto signupDto) {
    return userService.signUp(signupDto);
  }

  // signin
  @PostMapping("/signin")
  public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
    return userService.signIn(signInDto);
  }
}
