package com.unpredictableXcoders.BackendApplication.services;

import com.unpredictableXcoders.BackendApplication.dtos.UserDTO;
import com.unpredictableXcoders.BackendApplication.entities.Provider;
import com.unpredictableXcoders.BackendApplication.entities.User;
import com.unpredictableXcoders.BackendApplication.exceptions.BadRequestException;
import com.unpredictableXcoders.BackendApplication.exceptions.UserAlreadyExistsException;
import com.unpredictableXcoders.BackendApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIMP implements UserService{


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO){
        if(userDTO.getEmail() == null || userDTO.getEmail().isBlank()){
            throw new BadRequestException("Email is required");
        }
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new UserAlreadyExistsException("Email already exists");
        }

        User user = modelMapper.map(userDTO, User.class);
        user.setProvider(userDTO.getProvider()!=null?userDTO.getProvider(): Provider.LOCAL);
        //todo: role assign here to user for authorization
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDTO getUserById(String userId) {
        return null;
    }

    @Override
    public Iterable<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user->modelMapper.map(user,UserDTO.class))
                .toList();
    }
}
