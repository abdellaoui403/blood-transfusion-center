package com.Blood.demo.repository;

import com.Blood.demo.entity.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {
}
