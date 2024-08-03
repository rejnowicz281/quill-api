package com.rejnowicz.quillapi.service.backgroundjobs;

import com.rejnowicz.quillapi.service.authorRequest.AuthorRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class CleanUpAuthorRequests {
    private final AuthorRequestService authorRequestService;

    @Scheduled(cron = "0 0 0 * * 1")
    public void cleanUpAuthorRequests() {
        String name = "clean up author requests";
        log.info("Start '{}' background job", name);
        authorRequestService.cleanUp();
        log.info("End '{}' background job", name);
    }
}

