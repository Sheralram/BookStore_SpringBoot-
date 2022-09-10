package com.bridgelabz.bookstorespringboot.appConfiguration;

import com.bridgelabz.bookstorespringboot.model.User;
import com.bridgelabz.bookstorespringboot.util.JwtToken;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class AppConfig {
    @Bean
    public BCryptPasswordEncoder bcryptpasswordencoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtToken jwttoken() {
        return new JwtToken();
    }

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}