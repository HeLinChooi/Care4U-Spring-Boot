package com.example.dto;

import com.example.model.User;

import lombok.Data;

@Data
public class SignInResponseDto {

  final private String status;
  final private String token;
  final private long id;
  final private String name;
  final private String email;

  public SignInResponseDto(String status, String token, long l, String name, String email){
    this.status = status;
    this.token = token;
    this.id = l;
    this.name = name;
    this.email = email;
  }
}
