package com.rejnowicz.quillapi.configuration.security.jwt;

import com.rejnowicz.quillapi.configuration.security.SecurityConstants;
import com.rejnowicz.quillapi.configuration.security.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JWTGenerator {
    private static final Key key = SecurityUtils.getSecurityKey();

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();

        Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        return Jwts.builder().setSubject(username).setIssuedAt(currentDate).setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512).compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Invalid JWT token");
        }
    }
}
