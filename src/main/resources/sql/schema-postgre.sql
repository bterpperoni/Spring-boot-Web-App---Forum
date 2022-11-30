/*
 Base de données de test.
 */
ALTER USER postgres WITH PASSWORD 'password';

DROP TABLE IF EXISTS stories;

CREATE TABLE stories(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(255),
    creation_date TIMESTAMP,
    last_edit_date TIMESTAMP);

INSERT INTO stories(title, content, creation_date, last_edit_date)
VALUES
('Test', 'test', NOW(), NOW()),
('Test2', 'test2', NOW(), NOW());