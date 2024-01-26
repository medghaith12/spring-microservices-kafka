package com.kafka.producer.Controller;


import com.kafka.producer.Services.IProductService;
import com.kafka.producer.config.KafkaProducerService;
import com.kafka.producer.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {

    private final IProductService service;

    private final KafkaProducerService kafkaProducerService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(service.getProduct(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        Product savedProduct = service.addProduct(product);
        kafkaProducerService.sendMessage("create", savedProduct);
        return savedProduct;
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = service.updateProduct(product);
        kafkaProducerService.sendMessage("update", updatedProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
        kafkaProducerService.sendMessage("delete", new Product(id, null, 0.0));
    }
}
