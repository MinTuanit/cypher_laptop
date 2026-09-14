package com.example.cypher_laptop.service;

import com.example.cypher_laptop.dto.record.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ProductService {

    Page<ProductResponse>  getAllProducts(String name, String brand, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);

    Page<ProductResponse>  getActiveByCategory(Pageable pageable);
}
