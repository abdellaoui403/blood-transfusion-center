package com.Blood.demo.repository;

import com.Blood.demo.entity.Donor;
import com.Blood.demo.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface DonorRepository extends MongoRepository<Donor, String> {
	 Donor findByUser(User user);
}
