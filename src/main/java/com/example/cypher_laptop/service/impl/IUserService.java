package com.example.cypher_laptop.service.impl;

import com.example.cypher_laptop.dto.record.UserRequest;
import com.example.cypher_laptop.dto.record.UserResponse;
import com.example.cypher_laptop.dto.request.UserRq;
import com.example.cypher_laptop.dto.response.UserRp;
import com.example.cypher_laptop.entity.User;
import com.example.cypher_laptop.mapper.UserMapper;
import com.example.cypher_laptop.repository.UserRepository;
import com.example.cypher_laptop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IUserService implements UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;

    @Override
    public void create(UserRequest rq) {
        userRepo.save(maptoEntity(rq));
    }

    @Override
    public void update(String id, UserRequest rq) {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exist!");
        }

        User userUpdate = user.get();
        userUpdate.setAddress(rq.address());
        userUpdate.setEmail(rq.email());
        userUpdate.setName(rq.name());
        userUpdate.setPassword(rq.password());
        userUpdate.setPhonenumber(rq.phonenumber());
        userRepo.save(userUpdate);
    }

    @Override
    public List<UserResponse> index() {
        List<User> list = userRepo.findAll();

        return list.stream().map(this::maptoResponseOfMapStruct).toList();
    }

    @Override
    public void delete(String id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exist!");
        }
        userRepo.delete(user.get());
    }

    private User maptoEntity(UserRq rq) {
        return User.builder()
                .name(rq.getName())
                .address(rq.getAddress())
                .email(rq.getEmail())
                .phonenumber(rq.getPhonenumber())
                .username(rq.getUsername())
                .password(rq.getPassword())
                .build();
    }

    private UserRp maptoResponse(User user) {
        return UserRp.builder()
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .phonenumber(user.getPhonenumber())
                .username(user.getUsername())
                .build();
    }

    private User maptoEntity(UserRequest userRequest) {
        return userMapper.toEntity(userRequest);
    }

    private UserResponse maptoResponseOfMapStruct(User user) {
        return userMapper.toResponse(user);
    }
}
