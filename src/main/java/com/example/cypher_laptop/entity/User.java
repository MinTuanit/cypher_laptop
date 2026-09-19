package com.example.cypher_laptop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tl_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String username;
    private String password;
    @Column(length = 10)
    private String phonenumber;
    @Column(name = "address", length = 100)
    private String address;
    @Column(unique = true)
    private String email;
}
