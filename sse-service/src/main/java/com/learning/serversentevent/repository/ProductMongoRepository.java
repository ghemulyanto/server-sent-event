package com.learning.serversentevent.repository;

import com.learning.serversentevent.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Product, String> {

}
