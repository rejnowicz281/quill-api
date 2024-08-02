CREATE TABLE if not exists messages
(
    id                      UUID PRIMARY KEY,
    content                 TEXT NOT NULL,
    created_at              TIMESTAMP NOT NULL,
    sender_id               UUID NOT NULL,
    receiver_id             UUID NOT NULL,
    referenced_post_id      UUID,
    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id),
    FOREIGN KEY (referenced_post_id) REFERENCES posts(id)
);
