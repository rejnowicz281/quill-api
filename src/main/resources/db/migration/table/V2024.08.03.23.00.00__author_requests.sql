CREATE TABLE if not exists author_requests
(
    id                      UUID PRIMARY KEY,
    user_id                 UUID NOT NULL,
    details                 TEXT NOT NULL,
    created_at              TIMESTAMP NOT NULL,
    status                  VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
