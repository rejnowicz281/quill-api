package com.rejnowicz.quillapi.model.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    private String name;
}