package com.example.cypher_laptop.dto.record;

import com.example.cypher_laptop.enums.ProductStatus;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String slug,
        String description,
        BigDecimal price,
        BigDecimal salePrice,
        Integer stockQuantity,
        String brand,
        String thumbnailUrl,
        ProductStatus status
) {
}
