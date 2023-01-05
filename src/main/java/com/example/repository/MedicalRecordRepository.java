package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer>{
  MedicalRecord findById(int id);
}