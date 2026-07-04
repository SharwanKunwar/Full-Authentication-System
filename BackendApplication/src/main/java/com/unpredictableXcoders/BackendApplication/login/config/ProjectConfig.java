package com.unpredictableXcoders.BackendApplication.login.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public ModelMapper modalMapper(){
        return new ModelMapper();
    }
}
