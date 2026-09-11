package com.example.cypher_laptop.controller;

import com.example.cypher_laptop.dto.record.UserRequest;
import com.example.cypher_laptop.dto.record.UserResponse;
import com.example.cypher_laptop.dto.request.UserRq;
import com.example.cypher_laptop.dto.response.UserRp;
import com.example.cypher_laptop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> showListUser() {
        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRq) {
        userService.create(userRq);
        return new ResponseEntity<>("Create new user successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody UserRequest userq) {
        userService.update(id, userq);
        return new ResponseEntity<>("Update a user successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return new ResponseEntity<>("Delete a user successfully", HttpStatus.OK);
    }
}
