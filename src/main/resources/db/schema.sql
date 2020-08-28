DROP TABLE if exists user;

CREATE TABLE user (
   id INT NOT NULL,
   userName VARCHAR(50) NOT NULL,
   userPass VARCHAR(20) NOT NULL,
   isAdmin BOOLEAN
);