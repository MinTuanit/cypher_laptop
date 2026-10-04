package com.example.cypher_laptop.dto.record;

import java.io.Serializable;

public record CacheBenchmarkResponse(
        ProductCacheResponse product,
        String source,
        long executionTimeMs,
        String databaseLoadReduction,
        String explanation
) implements Serializable {
}