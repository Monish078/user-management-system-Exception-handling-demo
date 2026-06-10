package com.ExceptionHandling_Demo.UserManagement.controller;

import com.ExceptionHandling_Demo.UserManagement.entity.UserEntity;
import com.ExceptionHandling_Demo.UserManagement.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping()  // ese hi hai
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello!");
    }

    @GetMapping("/all") // sare user ko lane ka meth
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // jab user create kare
    @PostMapping()
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity    user) {
        UserEntity createdUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // ek method user ko delete karne ke liye
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();  // http 204 no content return karega

    }

}
