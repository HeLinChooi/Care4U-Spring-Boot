package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Patient;
import com.example.repository.PatientRepository;

@Service
public class PatientService {
  @Autowired
  private PatientRepository repository;

  public Patient savePatient(Patient patient) {
    return repository.save(patient);
  }

  public List<Patient> getPatients() {
    return repository.findAll();
  }

  public Patient getPatientById(int id) {
    return repository.findById(id).orElse(null);
  }

  public Patient getPatientByEmail(String email) {
    return repository.findByEmail(email);
  }

  public List<Patient> getPatientByName(String name) {
    return repository.findAllByName(name);
  }

  public String deletePatientById(int id) {
    repository.deleteById(id);
    return "patient profile removed: " + id;
  }

  public String deletePatientByEmail(String email) {
    repository.deleteByEmail(email);
    return "patient profile removed: " + email;
  }

  public Patient updatePatient(Patient patient) {
    Patient existingPatient = repository.findById(patient.getId()).orElse(null);
    existingPatient.setName(patient.getName());
    existingPatient.setAge(patient.getAge());
    existingPatient.setGender(patient.isGender());
    existingPatient.setPhoneNo(patient.getPhoneNo());
    existingPatient.setEmail(patient.getEmail());
    return repository.save(existingPatient);
  }
}