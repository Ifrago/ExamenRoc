DROP DATABASE IF EXISTS gestion;
CREATE DATABASE gestion;
USE gestion;

CREATE TABLE users (
  username varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  FisrtName varchar(30),
  LastName varchar(30),
  PRIMARY KEY (username)
);

INSERT INTO USERS (username, password, FisrtName, LastName) 
VALUES ('Muffy', '12345678', 'Muffy', 'Simpson');
INSERT INTO USERS (username, password, FisrtName, LastName) 
VALUES ('Ivan', '87654321', 'Frago', 'Alvarez');

CREATE TABLE MESSAGES(
id INT AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
subject VARCHAR(30),
body VARCHAR(255),
PRIMARY KEY (id),
FOREIGN KEY (username) REFERENCES USERS(username)
);

INSERT INTO MESSAGES(id, username, subject, body) 
VALUES (NULL, 'Muffy', 'Prova', 'El primer missatge');

