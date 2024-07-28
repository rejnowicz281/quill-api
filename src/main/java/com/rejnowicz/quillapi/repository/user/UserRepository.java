package com.rejnowicz.quillapi.repository.user;


import com.rejnowicz.quillapi.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);

}
