package com.example.cypher_laptop.service.impl;

import com.example.cypher_laptop.dto.record.ProductResponse;
import com.example.cypher_laptop.entity.Product;
import com.example.cypher_laptop.mapper.ProductMapper;
import com.example.cypher_laptop.repository.ProductRepository;
import com.example.cypher_laptop.repository.specifications.ProductSpecification;
import com.example.cypher_laptop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public  Page<ProductResponse> getAllProducts(String name, String brand, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
        Page<Product> products = productRepository.findAll(ProductSpecification.filterProducts(name, brand, minPrice, maxPrice), pageable);
        return products.map(productMapper::toResponse);
    }

    @Override
    public Page<ProductResponse> getActiveByCategory(Pageable pageable) {
        return null;
    }
}
