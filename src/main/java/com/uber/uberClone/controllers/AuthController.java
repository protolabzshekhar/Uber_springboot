package com.uber.uberClone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Server is active";
    }

}
