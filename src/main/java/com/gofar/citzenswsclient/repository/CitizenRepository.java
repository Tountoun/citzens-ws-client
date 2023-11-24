package com.gofar.citzenswsclient.repository;

import com.gofar.citzenswsclient.entity.Citizen;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CitizenRepository extends MongoRepository<Citizen, String> {
    Optional<Citizen> findByCin(String cin);
    boolean existsByCin(String cin);
}
