package com.itus.mealdeal.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itus.mealdeal.models.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>{

}
