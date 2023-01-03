package com.example.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
  private String error;

  public ExceptionResponse(String error) {
    this.error = error;
  }

  public ExceptionResponse() {
  }
}
