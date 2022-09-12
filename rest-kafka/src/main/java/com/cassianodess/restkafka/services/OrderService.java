package com.cassianodess.restkafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private KafkaTemplate<Object, Object> template;

    public <T> String addEvent(String topic, T data) {
        this.template.send(topic, data);
        return "Success";
    }
    
}
