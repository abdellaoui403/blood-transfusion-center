package com.Blood.demo.service;

import com.Blood.demo.entity.Admin;
import com.Blood.demo.entity.Donor;
import com.Blood.demo.entity.MedicalRecord;
import com.Blood.demo.entity.User;
import com.Blood.demo.repository.AdminRepository;
import com.Blood.demo.repository.DonorRepository;
import com.Blood.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Donor registerDonor(User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("DONOR"); // Set role to "ADMIN"
        user = userRepository.save(user);
        Donor donor = new Donor();
        donor.setUser(user);
        return donorRepository.save(donor);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Donor getDonorByUser(User user) {
        return donorRepository.findByUser(user);
    }

    public MedicalRecord getMedicalRecordForDonor(String donorId) {
        Donor donor = donorRepository.findById(donorId).orElse(null);
        return donor != null ? donor.getMedicalRecord() : null;
    }
}
