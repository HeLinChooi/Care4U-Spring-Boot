package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.CustomException;
import com.example.model.Patient;
import com.example.service.PatientService;

@RestController
public class PatientController {
  @Autowired
  private PatientService service;

  @PostMapping("/patient")
  public Patient addPatient(@RequestBody Patient patient) {
    Patient existingPatientWithSameEmail = findPatientByEmail(patient.getEmail());
    if (existingPatientWithSameEmail != null) {
      throw new CustomException("The email has been used by other account.");
    }
    return service.savePatient(patient);
  }

  @GetMapping("/patients") // yongming test
  public List<Patient> findAllPatients() {
    return service.getPatients();
  }

  @GetMapping("/patient-by-id/{id}") // yongming test
  public Patient findPatientById(@PathVariable int id) {
    return service.getPatientById(id);
  }

  // ERROR: email should be unique
  @GetMapping("/patient/{email}") // yongming test
  public Patient findPatientByEmail(@PathVariable String email) {
    return service.getPatientByEmail(email);
  }

  @GetMapping("/patients/{name}") // yongming test
  public List<Patient> findPatientByName(@PathVariable String name) {
    return service.getPatientByName(name);
  }

  @PutMapping("/patient")
  public Patient updatePatient(@RequestBody Patient patient) {
    return service.updatePatient(patient);
  }

  @DeleteMapping("/delete-patient-by-id/{id}") // yongming test
  public String deletePatient(@PathVariable int id) {
    return service.deletePatientById(id);
  }

  @DeleteMapping("/delete-patient-by-email/{email}") // yongming test
  public String deletePatient(@PathVariable String email) {
    return service.deletePatientByEmail(email);
  }

}
