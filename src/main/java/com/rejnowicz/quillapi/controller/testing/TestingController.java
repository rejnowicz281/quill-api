package com.rejnowicz.quillapi.controller.testing;

import com.rejnowicz.quillapi.service.authorRequest.AuthorRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/manual")
public class TestingController {
    private final AuthorRequestService authorRequestService;

    @GetMapping("/skip-cron-jobs")
    public void skipCronJobs() {
        log.info("Manually cleaning up author requests...");
        authorRequestService.cleanUp();
    }
}
