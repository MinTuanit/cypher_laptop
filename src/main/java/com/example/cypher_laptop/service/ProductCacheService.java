package com.example.cypher_laptop.service;

import com.example.cypher_laptop.dto.record.CacheBenchmarkResponse;
import com.example.cypher_laptop.dto.record.ProductCacheResponse;

public interface ProductCacheService {

    // Lấy chi tiết sản phẩm với @Cacheable
    ProductCacheResponse getProductById(Long id);

    // Benchmark trực quan so sánh tốc độ DB vs Redis Cache
    CacheBenchmarkResponse getProductWithBenchmark(Long id);

    // Cập nhật sản phẩm với @CachePut
    ProductCacheResponse updateProduct(Long id, ProductCacheResponse request);

    // Xóa sản phẩm với @CacheEvict
    void deleteProduct(Long id);

    // Xóa toàn bộ cache sản phẩm với @CacheEvict(allEntries = true)
    void clearAllCache();
}