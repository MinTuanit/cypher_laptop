package com.example.cypher_laptop.mapper;

import com.example.cypher_laptop.dto.record.ProductResponse;
import com.example.cypher_laptop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductResponse toResponse(Product product);

}

