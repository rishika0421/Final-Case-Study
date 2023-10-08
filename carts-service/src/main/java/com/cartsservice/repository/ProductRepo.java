package com.cartsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cartsservice.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product, Integer> {

}

//package com.shyam.cartsservice.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.shyam.cartsservice.model.Product;
//
//@Repository
//public interface ProductRepo extends JpaRepository<Product, Integer> {
//
//}
