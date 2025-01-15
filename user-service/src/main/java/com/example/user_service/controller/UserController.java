package com.example.user_service.controller;

import com.example.user_service.entity.UserIN;
import com.example.user_service.entity.UserOUT;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.service.MD5HashingService;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MD5HashingService hashingService;

    @GetMapping("/{id}")
    public ResponseEntity<UserOUT> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userMapper.userToUserOut(user));
    }

    @PostMapping
    public ResponseEntity<UserOUT> createUser(@RequestBody UserIN userIN) throws NoSuchAlgorithmException {
        System.out.println("UserIn bevor hashing PW: " + userIN);
        userIN.setPassword(hashingService.stringToMD5(userIN.getPassword()));
        System.out.println("UserIn after hashing PW: " + userIN);
        User user = userMapper.userInToUser(userIN);
        UserOUT createdUser = userMapper.userToUserOut(userService.createUser(user));
        System.out.println("UserOut: " + createdUser);
        return  ResponseEntity.ok().body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUser(user);
        return ResponseEntity.ok().build();

    }
}
