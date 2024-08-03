package com.rejnowicz.quillapi.model.authorRequest;

import com.rejnowicz.quillapi.model.EntityBase;
import com.rejnowicz.quillapi.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "author_requests")
@Data
public class AuthorRequest extends EntityBase {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String details;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }
}
