CREATE TABLE if not exists users
(
    id                      UUID PRIMARY KEY,
    name                    VARCHAR(255) NOT NULL,
    email                   VARCHAR(255) NOT NULL,
    password                VARCHAR(255) NOT NULL,
    created_at              TIMESTAMP NOT NULL
);

CREATE TABLE if not exists roles
(
    id                              UUID PRIMARY KEY,
    name                            VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists users_roles
(
    user_id                         UUID NOT NULL,
    role_id                         UUID NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO roles (id, name) VALUES ('17332435-e15c-4561-b5dc-3e70efbff1c0', 'ROLE_USER');
INSERT INTO roles (id, name) VALUES ('27332435-e15c-4561-b5dc-3e70efbff1c0', 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES ('37332435-e15c-4561-b5dc-3e70efbff1c0', 'ROLE_AUTHOR');

INSERT INTO users (id, name, email, password, created_at) VALUES ('1f2034ad-aca6-1eb1-1e08-12c780c9e93b', 'Admin', 'admin@gmail.com', '$2a$10$g80utLk5ah3kVwbOnVhlT.889slVnhIwyY60.F7mn8BTYS.bgYeGG', NOW());
INSERT INTO users (id, name, email, password, created_at) VALUES ('2f2034ad-aca6-1eb1-1e08-12c780c9e93c', 'User', 'user@gmail.com', '$2a$10$g80utLk5ah3kVwbOnVhlT.889slVnhIwyY60.F7mn8BTYS.bgYeGG', NOW());
INSERT INTO users (id, name, email, password, created_at) VALUES ('3f2034ad-aca6-1eb1-1e08-12c780c9e93d', 'Author', 'author@gmail.com', '$2a$10$g80utLk5ah3kVwbOnVhlT.889slVnhIwyY60.F7mn8BTYS.bgYeGG', NOW());

INSERT INTO users_roles (user_id, role_id) VALUES ('1f2034ad-aca6-1eb1-1e08-12c780c9e93b', '27332435-e15c-4561-b5dc-3e70efbff1c0');
INSERT INTO users_roles (user_id, role_id) VALUES ('2f2034ad-aca6-1eb1-1e08-12c780c9e93c', '17332435-e15c-4561-b5dc-3e70efbff1c0');
INSERT INTO users_roles (user_id, role_id) VALUES ('3f2034ad-aca6-1eb1-1e08-12c780c9e93d', '37332435-e15c-4561-b5dc-3e70efbff1c0');