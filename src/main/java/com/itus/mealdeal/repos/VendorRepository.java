package com.itus.mealdeal.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itus.mealdeal.models.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, Integer>{

}
