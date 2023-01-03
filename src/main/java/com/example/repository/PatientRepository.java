package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Patient;

import jakarta.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
  Patient findByEmail(String email);

  List<Patient> findAllByName(String name);

  @Transactional
  void deleteByEmail(String email);
}
