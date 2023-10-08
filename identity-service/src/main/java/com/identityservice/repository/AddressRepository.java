package com.identityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.identityservice.entity.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address,Integer> {

}
