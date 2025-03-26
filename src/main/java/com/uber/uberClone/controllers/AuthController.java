package com.uber.uberClone.controllers;

import com.uber.uberClone.Services.UserServices;
import com.uber.uberClone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uber.uberClone.Services.jwtService;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class AuthController {
    @Autowired
    private UserServices userService;

    private jwtService  jwtService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Server is active";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){

        if(userService.userExistByEmail(user)){
            return ResponseEntity.badRequest().body("Email already exist");
        }
        userService.createUser(user);
        return ResponseEntity.ok().body("Account created successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        User exisitngUser = userService.findUserByEmail(user.getEmail());

        if (exisitngUser != null && userService.matchPassword(user, exisitngUser)) {
            String token = jwtService.generateToken(exisitngUser);
            return ResponseEntity.ok().body(token);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }


}
