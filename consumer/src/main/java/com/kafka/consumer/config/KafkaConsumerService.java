package com.kafka.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.Services.IProductService;
import com.kafka.consumer.entities.Product;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KafkaConsumerService {

    private final IProductService service;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "product-topic", groupId = "group-id")
    public void consume(ConsumerRecord<String, Object> record) {
        String operation = record.key();
        System.out.println("---------------"+operation + record.value());
        //Product product = (Product) record.value();
        try {
        Product product = objectMapper.readValue(record.value().toString(), Product.class);
            System.out.println(product.getName());

        switch (operation) {
            case "create":
                service.addProduct(product.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build());
                System.out.println("Received and saved Product: " + product);
                break;

            case "update":
                service.updateProduct(product);
                System.out.println("Received and updated Product: " + product);
                break;

            case "delete":
                service.deleteProduct(product.getId());
                System.out.println("Received and deleted Product with ID: " + product.getId());
                break;

            default:
                System.out.println("Unknown operation: " + operation);
        }
        } catch (Exception e) {
            System.err.println("Error processing Kafka message: " + e.getMessage());
        }

    }
}
