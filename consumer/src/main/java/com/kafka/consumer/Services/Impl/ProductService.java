package com.kafka.consumer.Services.Impl;

import com.kafka.consumer.Repository.ProductRepository;
import com.kafka.consumer.Services.IProductService;
import com.kafka.consumer.entities.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository repository;
    @Override
    public void addProduct(Product product) {
        repository.insert(product);
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
