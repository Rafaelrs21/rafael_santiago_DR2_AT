CREATE TABLE sprint (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    project_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES project(id)
);