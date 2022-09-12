package com.cassianodess.mskafka.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassianodess.mskafka.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    
}
