package com.Blood.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medical_records")
public class MedicalRecord {

    @Id
    private String id;

    private String donorId; // This could be used to link the record to a donor
    private String bloodPressure;
    private String bloodType;
    private String healthConditions;
    private String allergies;

    // Constructors
    public MedicalRecord() {}

    public MedicalRecord(String id, String donorId, String bloodPressure, String bloodType, String healthConditions, String allergies) {
        this.id = id;
        this.donorId = donorId;
        this.bloodPressure = bloodPressure;
        this.bloodType = bloodType;
        this.healthConditions = healthConditions;
        this.allergies = allergies;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getHealthConditions() {
        return healthConditions;
    }

    public void setHealthConditions(String healthConditions) {
        this.healthConditions = healthConditions;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id='" + id + '\'' +
                ", donorId='" + donorId + '\'' +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", healthConditions='" + healthConditions + '\'' +
                ", allergies='" + allergies + '\'' +
                '}';
    }
}
