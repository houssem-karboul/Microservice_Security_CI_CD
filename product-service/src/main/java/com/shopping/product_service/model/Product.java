package com.shopping.product_service.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Slf4j
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
