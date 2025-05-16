package com.shopping.product_service.Dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotNull(message = "Null value for Id is not allowed") String id,
        @NotNull(message = "Null value for name is not allowed")String name,
        @NotNull(message = "Null value for description is not allowed") String description,
        @NotNull(message = "Null value for price is not allowed") BigDecimal price
){

}
