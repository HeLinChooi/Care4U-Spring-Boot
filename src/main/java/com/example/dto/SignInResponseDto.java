package com.example.dto;

import lombok.Data;

@Data
public class SignInResponseDto {

  final private String status;
  final private String token;
}
