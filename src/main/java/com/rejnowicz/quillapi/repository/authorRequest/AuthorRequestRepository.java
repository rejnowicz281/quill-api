package com.rejnowicz.quillapi.repository.authorRequest;

import com.rejnowicz.quillapi.model.authorRequest.AuthorRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRequestRepository extends JpaRepository<AuthorRequest, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM AuthorRequest a WHERE a.status = 'ACCEPTED' OR a.status = 'REJECTED'")
    void cleanUp();
}
