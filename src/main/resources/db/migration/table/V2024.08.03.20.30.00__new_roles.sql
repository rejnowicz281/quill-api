INSERT INTO roles (id, name) VALUES ('47332435-e15c-4561-b5dc-3e70efbff1c0', 'ROLE_ROOT');

INSERT INTO users (id, name, email, password, created_at) VALUES ('4f2034ad-aca6-1eb1-1e08-12c780c9e93b', 'ROOT', 'root@gmail.com', '$2a$10$g80utLk5ah3kVwbOnVhlT.889slVnhIwyY60.F7mn8BTYS.bgYeGG', NOW());

INSERT INTO users_roles (user_id, role_id) VALUES ('4f2034ad-aca6-1eb1-1e08-12c780c9e93b', '47332435-e15c-4561-b5dc-3e70efbff1c0');