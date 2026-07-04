package com.unpredictableXcoders.BackendApplication.login.services;

import com.unpredictableXcoders.BackendApplication.login.dtos.UserDTO;

public interface UserService {

    //create user
    UserDTO createUser(UserDTO userDTO);

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
