package com.unpredictableXcoders.BackendApplication.login.services;

import com.unpredictableXcoders.BackendApplication.exceptions.ResourceNotFoundException;
import com.unpredictableXcoders.BackendApplication.login.dtos.UserDTO;
import com.unpredictableXcoders.BackendApplication.login.entities.Provider;
import com.unpredictableXcoders.BackendApplication.login.entities.User;
import com.unpredictableXcoders.BackendApplication.exceptions.BadRequestException;
import com.unpredictableXcoders.BackendApplication.exceptions.UserAlreadyExistsException;
import com.unpredictableXcoders.BackendApplication.login.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceIMP implements UserService{


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO)
    {
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
    public UserDTO getUserByEmail(String email)
    {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found with email: " + email));
        User savedUser = modelMapper.map(user, User.class);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userId)
    {
        UUID uId = UUID.fromString(userId);
        User existingUser = userRepository.findById(uId).orElseThrow(()-> new ResourceNotFoundException("User not found with id " + uId));
        // email must not be changeable & password for now !
        if(userDTO.getName() != null) existingUser.setName(userDTO.getName());
        if(userDTO.getProvider() != null) existingUser.setProvider(userDTO.getProvider());
        if(userDTO.getImage() != null) existingUser.setImage(userDTO.getImage());
        existingUser.setEnable(userDTO.isEnable());

        User user = userRepository.save(existingUser);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteUser(String userId)
    {
        UUID uId = UUID.fromString(userId);
        User user = userRepository.findById(uId).orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + uId));
        userRepository.delete(user);
    }

    @Override
    public UserDTO getUserById(String userId)
    {
        UUID uId = UUID.fromString(userId);
        User user = userRepository.findById(uId).orElseThrow(()-> new ResourceNotFoundException("User not found with id " + userId));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public Iterable<UserDTO> getAllUsers()
    {
        return userRepository
                .findAll()
                .stream()
                .map(user->modelMapper.map(user,UserDTO.class))
                .toList();
    }
}
