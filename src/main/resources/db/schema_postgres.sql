CREATE TABLE measurements (
    id SERIAL PRIMARY KEY,
    address VARCHAR(50) NOT NULL,
    hydrant_type VARCHAR(20) NOT NULL,
    hydrant_subtype VARCHAR (20) NOT NULL,
    hydrant_diameter VARCHAR (20) NOT NULL,
    static_pressure NUMERIC NOT NULL,
    dynamic_pressure NUMERIC NOT NULL,
    hydrant_efficiency  NUMERIC  NOT NULL,
    photo bytea,
    created_at DATE,
    updated_at DATE
);

ALTER TABLE measurements ALTER COLUMN photo SET STORAGE EXTERNAL;

CREATE TABLE descriptions (
    id SERIAL PRIMARY KEY,
    measurement_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    status INT,
    comments VARCHAR(50),
    created_at DATE,
    updated_at DATE
);

CREATE TABLE users (
        id SERIAL PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        surname VARCHAR(50) NOT NULL,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        role VARCHAR(50) NOT NULL,
        created_at DATE,
        updated_at DATE
);