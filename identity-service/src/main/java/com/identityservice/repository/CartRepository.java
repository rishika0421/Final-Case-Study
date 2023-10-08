package com.identityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.identityservice.entity.Cart;

public interface CartRepository extends MongoRepository<Cart,Integer>{

}
