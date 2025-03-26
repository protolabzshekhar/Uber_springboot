package com.uber.uberClone.Services;

import com.uber.uberClone.Repository.UserRepository;
import com.uber.uberClone.models.User;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    //Create user
    public User createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public boolean userExistByEmail(User user){
        return userRepository.existsByEmail(user.getEmail());
    }
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean matchPassword(User user,User existingUser){
        return encoder.matches(user.getPassword(),existingUser.getPassword());
    }



}
