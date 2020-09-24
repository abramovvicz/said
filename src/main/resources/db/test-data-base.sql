INSERT INTO measurements (address, hydrant_type, hydrant_subtype, hydrant_diameter, created_at, photo)
VALUES ('dupa', 'INSIDE', 'UNDEFINED', 'DN25', '2004-12-31', FILE_READ('classpath:/db/said.jpg')),
('test1', 'INSIDE', 'UNDEFINED', 'DN33', '2012-01-01', FILE_READ('classpath:/db/said.jpg')),
 ('dupa2', 'OUTSIDE','UNDERGROUND', 'DN80','2020-04-05', FILE_READ('classpath:/db/said.jpg')),
  ('dupa3', 'OUTSIDE','GROUND', 'DN100','1982-11-12', FILE_READ('classpath:/db/said.jpg'));

INSERT INTO descriptions (measurement_id, name, status, comments)
VALUES (1, 'parametr pierwszy', 0, 'test comments')
, (1, 'parametr drugi', 1, 'test comments of the same obj')
, (2,'parametr pierwszy', 2, 'comments')
, (3, 'parametr 100 ', 1, 'chuj' );

INSERT INTO users (name, surname, username, password, role)
VALUES ('bartosz', 'abramovvicz', 'dzik_programowania', 'trudne_haslo', 'ADMIN')
, ('lukasz', 'tarala', 'ogorek', 'latwe_haslo', 'ADMIN')
, ('imie', 'nazwisko', 'nicknejm', 'dupa123', 'USER');