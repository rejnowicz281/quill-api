package com.rejnowicz.quillapi.configuration.websocket;

import com.rejnowicz.quillapi.service.presence.PresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import java.security.Principal;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final PresenceService presenceService;

    @EventListener
    public void onWebSocketDisconnect(SessionDisconnectEvent event) {
        GenericMessage<?> message = (GenericMessage<?>) event.getMessage();

        MessageHeaders headers = message.getHeaders();

        Object principal = headers.get("simpUser");

        if (principal instanceof Principal) {
            String userId = ((Principal) principal).getName();
            presenceService.removeUser(userId);
        } else log.info("Presence: Could not get principal");
    }
}
