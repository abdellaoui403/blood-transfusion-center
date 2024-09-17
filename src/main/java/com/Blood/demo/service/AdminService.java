package com.Blood.demo.service;

import com.Blood.demo.entity.Admin;
import com.Blood.demo.entity.User;
import com.Blood.demo.repository.AdminRepository;
import com.Blood.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin registerAdmin(User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ADMIN"); // Set role to "ADMIN"
        user = userRepository.save(user);
        Admin admin = new Admin();
        admin.setUser(user);
        return adminRepository.save(admin);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
