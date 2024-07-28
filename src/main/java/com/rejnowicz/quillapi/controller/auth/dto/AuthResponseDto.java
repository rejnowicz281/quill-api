package com.rejnowicz.quillapi.controller.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@JsonInclude(NON_EMPTY)
public class AuthResponseDto {
    private String token;
    private String error;

    public AuthResponseDto(String token) {
        this.token = token;
    }

    public AuthResponseDto(String token, String error) {
        this.token = token;
        this.error = error;
    }
}
