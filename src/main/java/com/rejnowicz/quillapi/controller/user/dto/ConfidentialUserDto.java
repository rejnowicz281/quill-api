package com.rejnowicz.quillapi.controller.user.dto;

import com.rejnowicz.quillapi.model.role.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ConfidentialUserDto {
    private UUID id;
    private String name;
    private String email;
    private Date createdAt;
    private List<Role> roles;
    private String password;
}
