package com.Blood.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin {

    @Id
    private String idAdmin;

    @DBRef
    private User user;

    // Constructors
    public Admin() {
        if (this.user != null) {
            this.user.setRole("ADMIN"); // Set role to "ADMIN" in the associated user
        }
    }

    public Admin(String idAdmin, User user) {
        this.idAdmin = idAdmin;
        this.user = user;
        if (this.user != null) {
            this.user.setRole("ADMIN"); // Set role to "ADMIN" in the associated user
        }
    }

    // Getters and Setters
    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin='" + idAdmin + '\'' +
                ", user=" + user +
                '}';
    }
}
