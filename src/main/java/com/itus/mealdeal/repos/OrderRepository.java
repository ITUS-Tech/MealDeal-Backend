package com.itus.mealdeal.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itus.mealdeal.models.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
	List<Order> findByUserId(int userId);
}
