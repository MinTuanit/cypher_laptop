package com.example.cypher_laptop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRp {
    private String id;
    private String name;
    private String username;
    private String phonenumber;
    private String address;
    private String email;
}
