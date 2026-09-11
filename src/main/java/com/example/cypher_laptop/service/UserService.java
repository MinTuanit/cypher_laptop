package com.example.cypher_laptop.service;

import com.example.cypher_laptop.dto.record.UserRequest;
import com.example.cypher_laptop.dto.record.UserResponse;

import java.util.List;

public interface UserService {

    void create(UserRequest rq);

    void update(String id, UserRequest rq);

    List<UserResponse> index();

    void delete(String id);
}
