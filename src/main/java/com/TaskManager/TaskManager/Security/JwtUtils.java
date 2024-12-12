package com.TaskManager.TaskManager.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${mock.jwt.token}")
    private String JWTToken;

    public  boolean validateToken(String token) {
        try {
            // Validate against the hardcoded token
            return JWTToken.equals(token);
        } catch (Exception e) {
            return false;
        }
    }

}
