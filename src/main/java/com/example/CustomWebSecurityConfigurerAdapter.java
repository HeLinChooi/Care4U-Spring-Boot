package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
    return http.build();
  }

  // @Bean
  // public PasswordEncoder passwordEncoder() {
  // PasswordEncoder encoder =
  // PasswordEncoderFactories.createDelegatingPasswordEncoder();
  // return encoder;
  // }
}