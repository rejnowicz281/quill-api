CREATE TABLE if not exists comments
(
    id                      UUID PRIMARY KEY,
    content                 TEXT NOT NULL,
    created_at              TIMESTAMP NOT NULL,
    user_id                 UUID NOT NULL,
    post_id                 UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (post_id) REFERENCES posts(id)
);

