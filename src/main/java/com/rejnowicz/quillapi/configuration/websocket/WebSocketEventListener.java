package com.rejnowicz.quillapi.configuration.websocket;

import com.rejnowicz.quillapi.service.presence.PresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final PresenceService presenceService;

    @EventListener
    public void onWebSocketDisconnect(SessionDisconnectEvent event) { presenceService.sendPresenceUpdate(); }

    @EventListener
    public void onWebSocketConnected(SessionConnectEvent event) { presenceService.sendPresenceUpdate(); }
}
