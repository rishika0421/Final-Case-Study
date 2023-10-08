package com.identityservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.identityservice.entity.Customer;

@Repository
public interface UserCredentialRepository  extends MongoRepository<Customer,String> {
    Optional<Customer> findByFirstName(String username);
}
