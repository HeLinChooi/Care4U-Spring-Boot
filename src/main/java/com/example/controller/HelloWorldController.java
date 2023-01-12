package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://care4u.vercel.app/" })
public class HelloWorldController {
  @GetMapping("/")
  public String index() {
    return "Hello world";
  }
}