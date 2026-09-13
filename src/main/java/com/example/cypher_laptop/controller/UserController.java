package com.example.cypher_laptop.controller;

import com.example.cypher_laptop.common.ApiResponse;
import com.example.cypher_laptop.common.BaseController;
import com.example.cypher_laptop.dto.record.UserRequest;
import com.example.cypher_laptop.dto.record.UserResponse;
import com.example.cypher_laptop.dto.request.UserRq;
import com.example.cypher_laptop.dto.response.UserRp;
import com.example.cypher_laptop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping
    public ApiResponse<List<UserResponse>> showListUser() {
        return createSuccessResponse(userService.index());
    }

    @PostMapping
    public ApiResponse<String> createUser(@Valid @RequestBody UserRequest userRq) {
        userService.create(userRq);
        return createSuccessResponse("Create new user successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateUser(@Valid @PathVariable("id") String id, @RequestBody UserRequest userq) {
        userService.update(id, userq);
        return createSuccessResponse("Update a user successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return createSuccessResponse("Delete a user successfully");
    }
}
