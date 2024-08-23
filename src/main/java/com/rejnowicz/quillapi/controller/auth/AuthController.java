package com.rejnowicz.quillapi.controller.auth;

import com.rejnowicz.quillapi.controller.auth.dto.AuthResponseDto;
import com.rejnowicz.quillapi.controller.auth.dto.EditAccountDto;
import com.rejnowicz.quillapi.controller.auth.dto.LoginDto;
import com.rejnowicz.quillapi.controller.auth.dto.RegisterDto;
import com.rejnowicz.quillapi.repository.user.UserRepository;
import com.rejnowicz.quillapi.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @GetMapping("get-user-token")
    public ResponseEntity<AuthResponseDto> getUserToken() {
        String token = authService.getUserToken();

        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>(new AuthResponseDto("", "Email is already taken!"), HttpStatus.BAD_REQUEST);
        }

        String token = authService.register(registerDto);

        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);

        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @PutMapping("edit-account")
    public ResponseEntity<AuthResponseDto> editAccount(@RequestBody EditAccountDto editAccountDto) {
        String token = authService.editAccount(editAccountDto);

        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @DeleteMapping("delete-account")
    public ResponseEntity<Void> deleteAccount() {
        authService.deleteAccount();

        return ResponseEntity.ok().build();
    }
}
