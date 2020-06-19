CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  created_at TIMESTAMP,
  PRIMARY KEY (id)
) ;

INSERT INTO users (id, name, email, password)
VALUES (1, 'Odilio Noronha', 'odilionoronha@gmail.com', '$2a$12$OEGZM8zoG8CW/z.F35aJ.ezNw3qgN.xPGhDfydVQkXc0rJ/bTAeuu');

CREATE TABLE products (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  created_at TIMESTAMP,
  PRIMARY KEY (id)
) ;