package com.example.cypher_laptop.mapper;

import com.example.cypher_laptop.dto.record.UserRequest;
import com.example.cypher_laptop.dto.record.UserResponse;
import com.example.cypher_laptop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponse toResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    User toEntity(UserRequest request);
}
