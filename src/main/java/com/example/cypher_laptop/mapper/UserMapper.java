package com.example.cypher_laptop.mapper;

import com.example.cypher_laptop.dto.record.UserRequest;
import com.example.cypher_laptop.dto.record.UserResponse;
import com.example.cypher_laptop.entity.auth.User;
import com.example.cypher_laptop.entity.user.UserTest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponse toResponse(UserTest user);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    UserTest toEntity(UserRequest request);
}
