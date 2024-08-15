package com.rejnowicz.quillapi.service.presence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class PresenceService {
    private final SimpMessagingTemplate messagingTemplate;

    @Getter
    private final Set<String> activeUsers = ConcurrentHashMap.newKeySet();

    public void sendPresenceUpdate() {
        messagingTemplate.convertAndSend("/topic/presenceSync", activeUsers);
    }

    public void addUser(String userId, boolean update) {
        log.info("Presence: Adding active user {}", userId);

        activeUsers.add(userId);

        if (update) sendPresenceUpdate();
    }

    public void addUser(String userId) {
        addUser(userId, true);
    }

    public void removeUser(String userId, boolean update) {
        log.info("Presence: Removing active user {}", userId);

        activeUsers.remove(userId);

        if (update) sendPresenceUpdate();
    }

    public void removeUser(String userId) {
        removeUser(userId, true);
    }
}
