package com.rejnowicz.quillapi.configuration.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class SecurityUtils {

    @Value("${security.jwt.secret}")
    private String JWT_SECRET;

    public Key getSecurityKey() {
        byte[] decodedKey = JWT_SECRET.getBytes();

        return Keys.hmacShaKeyFor(decodedKey);
    }
}
