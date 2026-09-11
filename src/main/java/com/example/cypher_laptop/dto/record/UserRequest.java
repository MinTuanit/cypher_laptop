package com.example.cypher_laptop.dto.record;

public record UserRequest(
        String name,
        String username,
        String password,
        String phonenumber,
        String address,
        String email
) {
}
