package com.example.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "email" })
})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String email;
  private String password;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
