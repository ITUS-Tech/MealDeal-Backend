package com.itus.mealdeal.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itus.mealdeal.models.IdGenerator;

@Repository
public interface IdgenRepository extends MongoRepository<IdGenerator, String>{

}
