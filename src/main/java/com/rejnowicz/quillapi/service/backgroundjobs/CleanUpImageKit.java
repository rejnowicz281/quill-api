package com.rejnowicz.quillapi.service.backgroundjobs;

import com.rejnowicz.quillapi.service.imagekit.ImageKitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class CleanUpImageKit {
    private final ImageKitService imageKitService;

    @Scheduled(cron = "0 0 0 * * *")
    public void cleanUpImageKit() {
        String name = "clean up image kit";
        log.info("Start '{}' background job", name);
        imageKitService.cleanUp();
        log.info("End '{}' background job", name);
    }
}

