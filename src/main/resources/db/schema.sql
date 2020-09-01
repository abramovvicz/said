DROP TABLE if exists measurements;
DROP TABLE if exists details;

CREATE TABLE measurements (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(50) NOT NULL,
    hydrant_type VARCHAR(20) NOT NULL,
    hydrant_subtype VARCHAR (20) NOT NULL,
    hydrant_diameter VARCHAR (20) NOT NULL,
    measurement_date DATE
);

CREATE TABLE details (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    measurement_id INT NOT NULL,
    status INT,
    description VARCHAR(50)
);