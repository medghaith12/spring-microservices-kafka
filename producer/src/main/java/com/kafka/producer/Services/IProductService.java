package com.kafka.producer.Services;

import com.kafka.producer.entities.Product;

import java.util.List;

public interface IProductService {
    public Product addProduct(Product product);

    public Product updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProduct(String id);

    public void deleteProduct(String id);
}
