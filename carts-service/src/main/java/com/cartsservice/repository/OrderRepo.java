package com.cartsservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cartsservice.model.Orders;

@Repository
public interface OrderRepo extends MongoRepository<Orders, Integer> {

}

//package com.shyam.cartsservice.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.shyam.cartsservice.model.Orders;
//
//@Repository
//public interface OrderRepo extends JpaRepository<Orders, Integer> {
//
//}
