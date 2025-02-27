package com.example.lectureconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "lecture-viewed", groupId = "lecture-consumer-group")
    public void lectureViewed(String message) {
        System.out.println(message);
    }
}
