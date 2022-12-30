package com.example.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

// here may cause issue cuz diff from YT video
@Data
@Entity
@Table(name = "token")
public class AuthToken {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  private String token;

  @Column(name = "created_date")
  private Date createdDate;

  @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
  @JoinColumn(nullable = false, name = "user_id")
  private User user;

  public AuthToken(User user) {
    this.user = user;
    this.createdDate = new Date();
    this.token = UUID.randomUUID().toString();
  }
  public AuthToken(){}
}
