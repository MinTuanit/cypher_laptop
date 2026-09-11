package com.example.cypher_laptop.dto.request;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRq {
    private String name;
    private String username;
    private String password;
    private String phonenumber;
    private String address;
    private String email;

}
