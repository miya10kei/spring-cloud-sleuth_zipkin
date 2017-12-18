CREATE TABLE IF NOT EXISTS user (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL
);

INSERT INTO user (name) VALUES ('suzuki');
INSERT INTO user (name) VALUES ('tanaka');
INSERT INTO user (name) VALUES ('sato');
INSERT INTO user (name) VALUES ('matsui');
INSERT INTO user (name) VALUES ('mori');
