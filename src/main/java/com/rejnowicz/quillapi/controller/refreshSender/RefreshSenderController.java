package com.rejnowicz.quillapi.controller.refreshSender;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RefreshSenderController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendRefreshTo/{userId}")
    public void sendRefreshTo(@DestinationVariable String userId) {
        messagingTemplate.convertAndSend("/topic/receiveRefreshAs/" + userId, "");
    }
}
