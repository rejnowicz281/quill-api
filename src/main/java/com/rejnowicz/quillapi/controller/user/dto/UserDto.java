package com.rejnowicz.quillapi.controller.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private Date createdAt;
}
