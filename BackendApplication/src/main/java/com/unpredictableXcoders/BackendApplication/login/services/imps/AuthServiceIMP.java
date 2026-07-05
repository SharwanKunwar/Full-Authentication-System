package com.unpredictableXcoders.BackendApplication.login.services.imps;

import com.unpredictableXcoders.BackendApplication.login.dtos.UserDTO;
import com.unpredictableXcoders.BackendApplication.login.entities.User;
import com.unpredictableXcoders.BackendApplication.login.services.AuthServiceHelper;
import com.unpredictableXcoders.BackendApplication.login.services.UserServiceHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMP implements AuthServiceHelper {

    private final UserServiceHelper userServiceHelper;

    @Override
    public UserDTO registerUser(UserDTO userDTO)
    {
        //Login : verify email, password, and default role
        UserDTO user = userServiceHelper.createUser(userDTO);
        return user;
    }
}
