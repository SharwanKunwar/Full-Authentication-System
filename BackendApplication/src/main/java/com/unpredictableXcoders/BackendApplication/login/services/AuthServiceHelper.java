package com.unpredictableXcoders.BackendApplication.login.services;

import com.unpredictableXcoders.BackendApplication.login.dtos.UserDTO;
import org.springframework.stereotype.Service;


public interface AuthServiceHelper {
    //Register user
    UserDTO registerUser(UserDTO userDTO);

    // Login user
}
