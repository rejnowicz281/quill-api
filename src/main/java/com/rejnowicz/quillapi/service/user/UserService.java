package com.rejnowicz.quillapi.service.user;


import com.rejnowicz.quillapi.controller.user.dto.UserDto;
import com.rejnowicz.quillapi.repository.user.UserRepository;
import com.rejnowicz.quillapi.service.user.mapper.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDtoMapper::map).toList();
    }
}
