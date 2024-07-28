package com.rejnowicz.quillapi.service.user.mapper;

import com.rejnowicz.quillapi.controller.user.dto.UserDto;
import com.rejnowicz.quillapi.model.user.UserEntity;

public class UserDtoMapper {
    public static UserDto map(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
