package com.kafka.consumer.Services;

import com.kafka.consumer.entities.Product;

import java.util.List;

public interface IProductService {
    public void addProduct(Product product);

    public Product updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProduct(String id);

    public void deleteProduct(String id);
}
