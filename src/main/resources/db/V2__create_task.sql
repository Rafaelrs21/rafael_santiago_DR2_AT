CREATE TABLE task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    owner_id BIGINT,
    sprint_id BIGINT,
    FOREIGN KEY (owner_id) REFERENCES user(id),
    FOREIGN KEY (sprint_id) REFERENCES sprint(id)
);