package com.kafka.producer.config;

import com.kafka.producer.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, Product> kafkaTemplate;

    private static final String TOPIC = "product-topic";

    public void sendMessage(String operation, Product product) {
        kafkaTemplate.send(TOPIC, operation, product);
    }
}
