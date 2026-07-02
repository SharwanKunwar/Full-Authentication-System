package com.unpredictableXcoders.BackendApplication.controllers;

import com.unpredictableXcoders.BackendApplication.dtos.UserDTO;
import com.unpredictableXcoders.BackendApplication.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws IllegalAccessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> getAllUsers() throws IllegalAccessException {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
