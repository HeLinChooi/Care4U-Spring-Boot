package com.example.dto;

public class MedicalRecordDto {
    //for create it can be optional 
    //for update we need the id if we use id
    private Integer id;
    private String description;
    private String severity;
    private String symptom;
    private String diagnosis;
    private String treatment;
    private Integer patient_id;

    

    public MedicalRecordDto() {
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getSymptom() {
        return symptom;
    }
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public Integer getPatient_id() {
        return patient_id;
    }
    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    
    
}
