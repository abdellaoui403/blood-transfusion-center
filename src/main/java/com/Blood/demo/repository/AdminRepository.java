package com.Blood.demo.repository;

import com.Blood.demo.entity.Admin;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {

    // You can add custom query methods here if needed
}
