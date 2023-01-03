package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Specialization of @Component for classes that declare @ExceptionHandler methods to be shared across multiple @Controller classes.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(value = CustomException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public final ExceptionResponse handleCustomException(
      CustomException exception) {
    ExceptionResponse response = new ExceptionResponse(exception.getMessage());
    return response;
  }

  @ExceptionHandler(value = AuthenticationFailException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public final ExceptionResponse handleAuthenticationFailException(
    AuthenticationFailException exception) {
      ExceptionResponse response = new ExceptionResponse(exception.getMessage());
    return response;
  }

}
