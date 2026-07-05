package com.unpredictableXcoders.BackendApplication.login.controllers;

import com.unpredictableXcoders.BackendApplication.login.dtos.UserDTO;
import com.unpredictableXcoders.BackendApplication.login.services.AuthServiceHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceHelper authServiceHelper;
    //Register
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authServiceHelper.registerUser(userDTO));
    }
}
