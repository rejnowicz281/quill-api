package com.rejnowicz.quillapi.service.presence;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PresenceService {
    private final SimpMessagingTemplate messagingTemplate;
    private final SimpUserRegistry userRegistry;

    public void sendPresenceUpdate() {
        var users = userRegistry.getUsers();

        var userIds = users.stream()
                .map(SimpUser::getName)
                .toArray();

        messagingTemplate.convertAndSend("/topic/presence-sync", userIds);
    }
}
