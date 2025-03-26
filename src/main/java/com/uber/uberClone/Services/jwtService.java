package com.uber.uberClone.Services;

import com.uber.uberClone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uber.uberClone.Util.jwtUtil;
@Service
public class jwtService {

    @Autowired
    private jwtUtil jwtUtil;

    public String generateToken(User user) {
        return jwtUtil.generateToken(user.getName());
    }
    public String getUserFromToken(String token){
        return jwtUtil.extractUsername(token);
    }

    public boolean validateToken(String token ,String userName){
        return jwtUtil.validateToken(token,userName);
    }

}
