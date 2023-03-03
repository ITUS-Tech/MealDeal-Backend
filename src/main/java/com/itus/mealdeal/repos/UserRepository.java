package com.itus.mealdeal.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.itus.mealdeal.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

}
