/*
 Base de données de test.
 */

DROP TABLE IF EXISTS stories;

CREATE TABLE stories(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(255),
    creationDate TIMESTAMP,
    lastEditDate TIMESTAMP);

INSERT INTO stories(title, content, creationDate, lastEditDate)
VALUES
('Test', 'test', NOW(), NOW()),
('Test2', 'test2', NOW(), NOW());