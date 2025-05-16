package com.shopping.product_service.Dto;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;


public record ProductResponse(
        String id,
        String name,
        String description,
        BigDecimal price) {
}
