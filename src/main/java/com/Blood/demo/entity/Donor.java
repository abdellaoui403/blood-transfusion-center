package com.Blood.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "donors")
public class Donor {

    @Id
    private String idDonor;
    private String bloodType;
    private String donationHistory;
    private String communicationPreferences;

    @DBRef
    private MedicalRecord medicalRecord;

    @DBRef
    private User user;

    // Constructors
    public Donor() {
        if (this.user != null) {
            this.user.setRole("DONOR"); // Set role to "DONOR" in the associated user
        }
    }

    public Donor(String idDonor, String bloodType, String donationHistory, String communicationPreferences, MedicalRecord medicalRecord, User user) {
        this.idDonor = idDonor;
        this.bloodType = bloodType;
        this.donationHistory = donationHistory;
        this.communicationPreferences = communicationPreferences;
        this.medicalRecord = medicalRecord;
        this.user = user;
        if (this.user != null) {
            this.user.setRole("DONOR"); // Set role to "DONOR" in the associated user
        }
    }

    // Getters and Setters
    public String getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(String idDonor) {
        this.idDonor = idDonor;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDonationHistory() {
        return donationHistory;
    }

    public void setDonationHistory(String donationHistory) {
        this.donationHistory = donationHistory;
    }

    public String getCommunicationPreferences() {
        return communicationPreferences;
    }

    public void setCommunicationPreferences(String communicationPreferences) {
        this.communicationPreferences = communicationPreferences;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "idDonor='" + idDonor + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", donationHistory='" + donationHistory + '\'' +
                ", communicationPreferences='" + communicationPreferences + '\'' +
                ", medicalRecord=" + medicalRecord +
                ", user=" + user +
                '}';
    }
}
