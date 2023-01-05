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
import com.example.model.MedicalRecord;
import com.example.service.MedicalRecordService;

@RestController
public class MedicalRecordController {
  @Autowired
  private MedicalRecordService service;

  @PostMapping("/medical-record")
  public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {   
    return service.saveMedicalRecord(medicalRecord);
  }
  
  @GetMapping("/medical-records")
  public List<MedicalRecord> findAllMedicalRecords() {
    return service.getMedicalRecords();
  }
  
  @GetMapping("/medical-record-by-id/{id}")
  public <Optional> MedicalRecord findMedicalRecordById(@PathVariable int id){
    if (service.getMedicalRecordById(id) == null) {
      throw new CustomException("Cannot find this patient medical record.");
    }
    return service.getMedicalRecordById(id);
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
