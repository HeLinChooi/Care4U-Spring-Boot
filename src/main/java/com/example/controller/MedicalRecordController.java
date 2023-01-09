package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MedicalRecordDto;
import com.example.exceptions.CustomException;
import com.example.model.MedicalRecord;
import com.example.model.Patient;
import com.example.repository.PatientRepository;
import com.example.service.MedicalRecordService;

@RestController
public class MedicalRecordController {
  @Autowired
  private MedicalRecordService service;

  @Autowired
  PatientRepository patientRepository;

  @PostMapping("/medical-record")
  public MedicalRecord addMedicalRecord(@RequestBody MedicalRecordDto medicalRecordDto) {  
    Optional<Patient> optionalPatient = patientRepository.findById(medicalRecordDto.getPatient_id());
    if(!optionalPatient.isPresent()){
      throw new CustomException("Cannot find this patient.");
    }
    return service.saveMedicalRecord(medicalRecordDto,optionalPatient.get());
  }
  
  @GetMapping("/medical-records")
  public List<MedicalRecordDto> findAllMedicalRecords() {
    return service.getMedicalRecords();
  } 

  @GetMapping("/medical-record-by-id/{id}")
  public MedicalRecord findMedicalRecordById(@PathVariable int id){
    if (service.getMedicalRecordById(id) == null) {
      throw new CustomException("Cannot find this patient medical record.");
    }
    return service.getMedicalRecordById(id);
  }
  @GetMapping("/medical-record-by-patient-id/{id}")
  public List<MedicalRecord> findMedicalRecordByPatientId(@PathVariable int id){
    if (service.getMedicalRecordsByPatientId(id).isEmpty()) {
      throw new CustomException("Cannot find this patient.");
    }
    return service.getMedicalRecordsByPatientId(id);
  }

  @PutMapping("/medical-record")
  public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
    return service.updateMedicalRecord(medicalRecord);
  }

  @DeleteMapping("/medical-record/{id}")
  public String deleteMedicalRecord(@PathVariable int id) {
    return service.deleteMedicalRecord(id);
  }

}
