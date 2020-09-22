DROP TABLE if exists measurements;
DROP TABLE if exists details;
DROP TABLE if exists users;

CREATE TABLE measurements (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(50) NOT NULL,
    hydrant_type VARCHAR(20) NOT NULL,
    hydrant_subtype VARCHAR (20) NOT NULL,
    hydrant_diameter VARCHAR (20) NOT NULL,
    photo blob,
    created_at DATE,
    updated_at DATE
);

CREATE TABLE descriptions (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    measurement_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    status INT,
    comments VARCHAR(50),
    created_at DATE,
    updated_at DATE
);

CREATE TABLE users (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        surname VARCHAR(50) NOT NULL,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        role VARCHAR(50) NOT NULL,
        created_at DATE,
        updated_at DATE
);