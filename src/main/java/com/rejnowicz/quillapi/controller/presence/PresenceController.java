package com.rejnowicz.quillapi.controller.presence;

import com.rejnowicz.quillapi.service.presence.PresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PresenceController {
    private final PresenceService presenceService;

    @MessageMapping("/presence/trackUser/{userId}")
    public void trackUser(@DestinationVariable String userId) {
        log.info("Presence: Enabling tracking for user {}", userId);
        presenceService.addUser(userId);
    }

    @MessageMapping("/presence/untrackUser/{userId}")
    public void untrackUser(@DestinationVariable String userId) {
        log.info("Presence: Disabling tracking for user {}", userId);
        presenceService.removeUser(userId);
    }
}
