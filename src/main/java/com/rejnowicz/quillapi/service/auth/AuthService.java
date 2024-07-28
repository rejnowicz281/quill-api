package com.rejnowicz.quillapi.service.auth;

import com.rejnowicz.quillapi.configuration.security.jwt.JWTGenerator;
import com.rejnowicz.quillapi.controller.auth.dto.EditAccountDto;
import com.rejnowicz.quillapi.controller.auth.dto.LoginDto;
import com.rejnowicz.quillapi.controller.auth.dto.RegisterDto;
import com.rejnowicz.quillapi.model.user.UserEntity;
import com.rejnowicz.quillapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    public String register(RegisterDto registerDto) {
        UserEntity user = new UserEntity();

        var name = registerDto.getName();

        if (isBlank(name)) {
            name = registerDto.getEmail();
        }

        user.setName(name);
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        userRepository.save(user);

        return authenticate(registerDto.getEmail(), registerDto.getPassword());
    }

    public String login(LoginDto loginDto) {
        return authenticate(loginDto.getEmail(), loginDto.getPassword());
    }

    public String editAccount(EditAccountDto editAccountDto) {
        var currentUser = getCurrentUser().orElseThrow(() -> new RuntimeException("User not found"));

        var name = editAccountDto.getName();
        var password = editAccountDto.getPassword();

        if (!isBlank(name)) {
            currentUser.setName(editAccountDto.getName());
        }

        if (!isBlank(editAccountDto.getPassword())) {
            currentUser.setPassword(passwordEncoder.encode(editAccountDto.getPassword()));
        }

        userRepository.save(currentUser);

        if (isBlank(password)) {
            return "";
        }

        return authenticate(currentUser.getEmail(), password);
    }

    private String authenticate(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtGenerator.generateToken(authentication);
    }

    public Optional<UserEntity> getCurrentUser() {
        var securityContext = SecurityContextHolder.getContext();

        var principal = securityContext.getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();

            return userRepository.findByEmail(email);
        } else {
            throw new IllegalStateException("Principal is not an instance of UserDetails");
        }
    }

    public void deleteAccount() {
        var currentUser = getCurrentUser().orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(currentUser);
    }
}
