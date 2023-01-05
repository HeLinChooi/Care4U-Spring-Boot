package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.MedicalRecordDto;
import com.example.model.MedicalRecord;
import com.example.model.Patient;
import com.example.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {
  @Autowired
  private MedicalRecordRepository repository;

  public MedicalRecord saveMedicalRecord(MedicalRecordDto medicalRecordDto, Patient patient){
    MedicalRecord medicalRecord = new MedicalRecord();
    medicalRecord.setDescription(medicalRecordDto.getDescription());
    medicalRecord.setSeverity(medicalRecordDto.getSeverity());
    medicalRecord.setSymptom(medicalRecordDto.getSymptom());
    medicalRecord.setDiagnosis(medicalRecordDto.getDiagnosis());
    medicalRecord.setTreatment(medicalRecordDto.getTreatment());
    medicalRecord.setPatient(patient);
    return repository.save(medicalRecord);
  }

  public List<MedicalRecord> getMedicalRecords() {
    return repository.findAll();
  }
  public MedicalRecord getMedicalRecordById(int id) {
    return repository.findById(id);//.orElse(null);
  }
  public String deleteMedicalRecord(int id) {
    repository.deleteById(id);
    return "Medical Record removed: "+id;
  }
  public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
    MedicalRecord existingMedicalRecord = repository.findById(medicalRecord.getId());//.orElse(null);
    existingMedicalRecord.setDescription(medicalRecord.getDescription());
    existingMedicalRecord.setSeverity(medicalRecord.getSeverity());
    existingMedicalRecord.setSymptom(medicalRecord.getSymptom());
    existingMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
    existingMedicalRecord.setTreatment(medicalRecord.getTreatment());
    return repository.save(existingMedicalRecord);
  }
}
