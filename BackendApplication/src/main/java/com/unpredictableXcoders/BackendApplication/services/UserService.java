package com.unpredictableXcoders.BackendApplication.services;

import com.unpredictableXcoders.BackendApplication.dtos.UserDTO;

public interface UserService {

    //create user
    UserDTO createUser(UserDTO userDTO) throws IllegalAccessException;

    // get user by email
    UserDTO getUserByEmail(String email);

    // update user
    UserDTO updateUser(UserDTO userDTO, String userId);

    //delete user
    void deleteUser(String userId);

    // get user by id
    UserDTO getUserById(String userId);

    //get all users
    Iterable<UserDTO> getAllUsers();





}
