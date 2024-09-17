package com.Blood.demo.payload;

public class LoginResponse {

    private String token;

    // Default constructor (required for frameworks like Jackson to serialize/deserialize objects)
    public LoginResponse() {}

    // Constructor with token parameter
    public LoginResponse(String token) {
        this.token = token;
    }

    // Getter and setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
