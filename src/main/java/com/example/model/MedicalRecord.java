package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MedicalRecord {
  @Id
  @GeneratedValue
  private int id;
  private String description;
  private String severity;
  private String symptom;
  private String diagnosis;
  private String treatment;
  
  @ManyToOne
  @JoinColumn(name="patient_id")
  Patient patient;
  
}
