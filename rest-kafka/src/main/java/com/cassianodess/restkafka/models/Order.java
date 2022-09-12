package com.cassianodess.restkafka.models;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private UUID id;
    private String name;
    private BigDecimal value;

}
