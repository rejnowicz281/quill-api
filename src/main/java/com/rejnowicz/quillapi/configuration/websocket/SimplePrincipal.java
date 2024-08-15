package com.rejnowicz.quillapi.configuration.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.Principal;

@Data
@AllArgsConstructor
public class SimplePrincipal implements Principal {
    private String name;
}