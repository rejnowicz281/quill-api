package com.rejnowicz.quillapi.service.user;


import com.rejnowicz.quillapi.configuration.security.SecurityUtils;
import com.rejnowicz.quillapi.controller.user.dto.ConfidentialUserDto;
import com.rejnowicz.quillapi.controller.user.dto.UserDto;
import com.rejnowicz.quillapi.repository.user.UserRepository;
import com.rejnowicz.quillapi.service.auth.AuthService;
import com.rejnowicz.quillapi.service.user.mapper.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDtoMapper::map).toList();
    }

    public List<ConfidentialUserDto> findAllConfidential() {
        return userRepository.findAll().stream()
                .map(UserDtoMapper::mapConfidential).toList();
    }
}
