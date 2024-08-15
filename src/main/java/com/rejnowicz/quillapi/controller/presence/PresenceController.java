package com.rejnowicz.quillapi.controller.presence;

import com.rejnowicz.quillapi.service.presence.PresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PresenceController {
    private final PresenceService presenceService;

    @MessageMapping("/presence-sync")
    public void presence() {
        presenceService.sendPresenceUpdate();
    }
}
