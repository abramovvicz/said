DROP TABLE IF EXISTS measurements CASCADE;
DROP TABLE IF EXISTS measurement CASCADE;
DROP TABLE IF EXISTS description CASCADE;
DROP TABLE IF EXISTS descriptions CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS dupa CASCADE;



CREATE TABLE measurement (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
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

ALTER TABLE measurement ALTER COLUMN photo SET STORAGE EXTERNAL;

CREATE TABLE description (
    id SERIAL PRIMARY KEY,
    measurement_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    status VARCHAR(5),
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