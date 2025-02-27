package com.uber.uberClone.controllers;

import com.uber.uberClone.Services.UserServices;
import com.uber.uberClone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthController {
    @Autowired
    private UserServices userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Server is active";
    }

    @PostMapping("/create")
    public  User createUser(@RequestBody User user){
        return userService.createUser(user);
    }


}
