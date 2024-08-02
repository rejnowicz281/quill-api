CREATE TABLE if not exists posts
(
    id                      UUID PRIMARY KEY,
    title                   VARCHAR(255) NOT NULL,
    content                 TEXT NOT NULL,
    created_at              TIMESTAMP NOT NULL,
    author_id               UUID NOT NULL,
    FOREIGN KEY (author_id) REFERENCES users(id)
);

