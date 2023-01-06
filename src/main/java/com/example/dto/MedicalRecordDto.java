package com.example.dto;

import lombok.Data;

@Data
public class MedicalRecordDto {
    private String description;
    private String severity;
    private String symptom;
    private String diagnosis;
    private String treatment;
    private Integer patient_id;   
}
