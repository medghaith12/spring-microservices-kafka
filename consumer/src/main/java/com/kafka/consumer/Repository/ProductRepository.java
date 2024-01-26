package com.kafka.consumer.Repository;

import com.kafka.consumer.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
