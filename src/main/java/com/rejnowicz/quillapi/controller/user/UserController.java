package com.rejnowicz.quillapi.controller.user;

import com.rejnowicz.quillapi.controller.user.dto.ConfidentialUserDto;
import com.rejnowicz.quillapi.controller.user.dto.UserDto;
import com.rejnowicz.quillapi.service.user.UserService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping("/confidential")
    public ResponseEntity<List<ConfidentialUserDto>> findAllConfidential() {
        return ResponseEntity.ok(userService.findAllConfidential());
    }
}
