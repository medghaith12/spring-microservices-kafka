package com.kafka.producer.Services.Impl;

import com.kafka.producer.Services.IProductService;
import com.kafka.producer.Repository.ProductRepository;
import com.kafka.producer.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository repository;
    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(String id) {
         repository.deleteById(id);
    }
}
