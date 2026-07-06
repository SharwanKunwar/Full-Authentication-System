package com.unpredictableXcoders.BackendApplication.login.security;


import com.unpredictableXcoders.BackendApplication.exceptions.ResourceNotFoundException;
import com.unpredictableXcoders.BackendApplication.login.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
     return userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("Invalid Email or password"));
    }
}
