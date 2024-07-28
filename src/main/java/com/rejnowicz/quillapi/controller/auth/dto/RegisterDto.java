package com.rejnowicz.quillapi.controller.auth.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String name;
    private String provider;
    private String password;
}
