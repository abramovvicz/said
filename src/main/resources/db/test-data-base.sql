INSERT INTO protocol (title) VALUES ('protocol 1'), ('protocol 2');

INSERT INTO measurements (title, protocol_id, address, hydrant_type, hydrant_subtype, hydrant_diameter, static_pressure,
dynamic_pressure, hydrant_efficiency, created_at, photo)
VALUES ('title1', 1, 'dupa', 'INSIDE', 'UNDEFINED', 'DN25_DR10', '0.43', '1.3', '4.12', '2004-12-31', ''),
('title2', 1,'test1', 'INSIDE', 'UNDEFINED', 'DN33_DR12', '0.43', '1.3', '4.12', '2012-01-01', ''),
 ('title3', 2,'dupa2', 'OUTSIDE','UNDERGROUND', 'DN80_DP22','0.43', '1.3', '4.12','2020-04-05', ''),
  ('title4', 2,'dupa3', 'OUTSIDE','GROUND', 'DN100_DP32','0.43', '1.3', '4.12', '1982-11-12', '');
--  ('title4', 2,'dupa3', 'OUTSIDE','GROUND', 'DN100_DP32','0.43', '1.3', '4.12', '1982-11-12', FILE_READ('classpath:/db/said.jpg'));


INSERT INTO descriptions (measurement_id, name, status, comments)
VALUES (1, 'parametr pierwszy', 'ok', 'test comments')
, (1, 'parametr drugi', 'nie ok', 'test comments of the same obj')
, (2,'parametr pierwszy', 'ok', 'comments')
, (2, 'parametr 100 ', 'nie ok', 'chuj' );

INSERT INTO users (name, surname, username, password, role, created_at)
VALUES ('bartosz', 'abramovvicz', 'dzik_programowania', 'trudne_haslo', 'ADMIN', '2020-09-29')
, ('lukasz', 'tarala', 'ogorek', 'latwe_haslo', 'ADMIN', '2020-09-29')
, ('imie', 'nazwisko', 'nicknejm', 'dupa123', 'USER', '2020-09-29');