package com.rejnowicz.quillapi.repository.user;


import com.rejnowicz.quillapi.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);

    @Query("SELECT u.avatarUrl FROM UserEntity u WHERE u.avatarUrl IN :avatarUrls")
    List<String> findExistingAvatarUrls(@Param("avatarUrls") List<String> avatarUrls);
}
