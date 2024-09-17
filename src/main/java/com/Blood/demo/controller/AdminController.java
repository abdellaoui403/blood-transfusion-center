package com.Blood.demo.controller;

import com.Blood.demo.entity.Admin;
import com.Blood.demo.entity.User;
import com.Blood.demo.payload.LoginRequest;
import com.Blood.demo.payload.LoginResponse;
import com.Blood.demo.service.AdminService;
import com.Blood.demo.service.UserService;
import com.Blood.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody User user) {
        adminService.registerAdmin(user);
        return ResponseEntity.ok("Admin registered successfully");
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
}
