package com.cassianodess.restkafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassianodess.restkafka.models.Order;
import com.cassianodess.restkafka.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Order order) {
        return ResponseEntity.ok(service.addEvent("SaveOrder", order));
    }

}
