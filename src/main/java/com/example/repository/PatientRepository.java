package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
  Patient findByEmail(String email);

  Patient findByName(String name);

  void deleteByEmail(String email);
}
