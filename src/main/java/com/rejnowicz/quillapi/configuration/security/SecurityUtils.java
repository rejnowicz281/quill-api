package com.rejnowicz.quillapi.configuration.security;

import com.rejnowicz.quillapi.model.user.UserEntity;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Key;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

public class SecurityUtils {
    public static Key getSecurityKey() {
        // TODO: move this to env and change it
        String keyString = "dDP0Pky0LqNWs/YvpEYsjZetDuivDh3289HRYeAFMsg+NNYBMd5Cj7cXEiQZYpg6JEQsHxgzbmxb34QkPNZ/o0B7WEdJTes3Wkgky41RBQCiVJczBFETed1AIp52JfZiHYGwvB7XxM6NRsVpJ+Fx6/XskNYOhn731Rljq5Xz0Jp2";

        byte[] decodedKey = keyString.getBytes();

        return Keys.hmacShaKeyFor(decodedKey);
    }
}
