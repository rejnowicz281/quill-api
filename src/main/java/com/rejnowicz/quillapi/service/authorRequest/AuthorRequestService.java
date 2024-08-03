package com.rejnowicz.quillapi.service.authorRequest;

import com.rejnowicz.quillapi.repository.authorRequest.AuthorRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorRequestService {
    private final AuthorRequestRepository authorRequestRepository;

    public void cleanUp() {
        authorRequestRepository.cleanUp();
    }
}
