package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Patient {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private int age;
  private boolean gender;
  private String phoneNo;
  @Column(unique = true)
  private String email;

}
