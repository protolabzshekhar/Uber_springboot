package com.uber.uberClone.Services;

import com.uber.uberClone.Repository.UserRepository;
import com.uber.uberClone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    //Create user
    public User createUser(User user){
        return userRepository.save(user);
    }

}
