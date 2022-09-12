package com.cassianodess.mskafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cassianodess.mskafka.models.Order;
import com.cassianodess.mskafka.repositories.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    
    @KafkaListener(topics = "SaveOrder", groupId = "MicroServiceSaveOrder")
    public void execute(ConsumerRecord<String, String> record) {
        log.info("Key: {}", record.key());
        log.info("Headers: {}", record.headers());
        log.info("partition: {}", record.partition());

        ObjectMapper mapper = new ObjectMapper();

        try {
            Order order = mapper.readValue(record.value(), Order.class);
            save(order);
            // TODO: Implement queue data response 
        } catch (JsonMappingException e) {
            log.error("Fail to convert: {}", e);
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            log.error("Fail to convert: {}", e);
            e.printStackTrace();
        }
        
    }

    public Order save(Order order) {
        log.info("Order saved: {}", order);
        return this.repository.save(order);
    }

}
