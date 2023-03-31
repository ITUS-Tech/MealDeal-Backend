package com.itus.mealdeal.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itus.mealdeal.models.ResetPassword;

public interface ResetPasswordRepository extends MongoRepository<ResetPassword, String>{

}
