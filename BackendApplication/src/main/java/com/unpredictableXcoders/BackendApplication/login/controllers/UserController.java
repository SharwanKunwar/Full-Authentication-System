package com.unpredictableXcoders.BackendApplication.login.controllers;

import com.unpredictableXcoders.BackendApplication.login.dtos.UserDTO;
import com.unpredictableXcoders.BackendApplication.login.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    //Create user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws IllegalAccessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }


    //Get all users
    @GetMapping("/all")
    public ResponseEntity<Iterable<UserDTO>> getAllUsers() throws IllegalAccessException {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    //Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    // update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO)
    {
        return ResponseEntity.ok(userService.updateUser(userDTO, userId));
    }

    //Delete user by id
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User has been deleted");
    }
}
