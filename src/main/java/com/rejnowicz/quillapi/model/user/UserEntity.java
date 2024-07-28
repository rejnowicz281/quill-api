package com.rejnowicz.quillapi.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rejnowicz.quillapi.model.EntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity extends EntityBase {
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password")
    @JsonIgnore
    private String password;
}
