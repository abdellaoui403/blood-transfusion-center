package com.Blood.demo.controller;

import com.Blood.demo.entity.Donor;
import com.Blood.demo.entity.MedicalRecord;
import com.Blood.demo.entity.User;
import com.Blood.demo.payload.LoginRequest;
import com.Blood.demo.payload.LoginResponse;
import com.Blood.demo.service.DonorService;
import com.Blood.demo.service.UserService;
import com.Blood.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerDonor(@RequestBody User user) {
        donorService.registerDonor(user);
        return ResponseEntity.ok("Donor registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user != null && userService.validatePassword(loginRequest.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.status(401).body(null);
    }
    @GetMapping("/medicalRecord")
    public ResponseEntity<MedicalRecord> getMedicalRecord(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7)); // Remove "Bearer " prefix
        User user = userService.findByEmail(email);
        if (user != null) {
            Donor donor = donorService.getDonorByUser(user);
            if (donor != null) {
                MedicalRecord medicalRecord = donorService.getMedicalRecordForDonor(donor.getIdDonor());
                return ResponseEntity.ok(medicalRecord);
            }
        }
        return ResponseEntity.status(404).body(null);
    }
}
