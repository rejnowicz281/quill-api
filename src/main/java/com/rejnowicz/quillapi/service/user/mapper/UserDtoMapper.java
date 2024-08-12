package com.rejnowicz.quillapi.service.user.mapper;

import com.rejnowicz.quillapi.controller.user.dto.ConfidentialUserDto;
import com.rejnowicz.quillapi.controller.user.dto.UserDto;
import com.rejnowicz.quillapi.model.user.UserEntity;

public class UserDtoMapper {
    public static UserDto map(UserEntity user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }

    public static ConfidentialUserDto mapConfidential(UserEntity user) {
        return ConfidentialUserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .roles(user.getRoles())
                .password(user.getPassword())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
}
