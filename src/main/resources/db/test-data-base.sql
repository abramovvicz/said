INSERT INTO measurements (address, hydrant_type, hydrant_subtype, hydrant_diameter, static_pressure,
dynamic_pressure, hydrant_efficiency, created_at, photo)
VALUES ('dupa', 'INSIDE', 'UNDEFINED', 'DN25', '0.43', '1.3', '4.12', '2004-12-31', ''),
('test1', 'INSIDE', 'UNDEFINED', 'DN33', '0.43', '1.3', '4.12', '2012-01-01', ''),
 ('dupa2', 'OUTSIDE','UNDERGROUND', 'DN80','0.43', '1.3', '4.12','2020-04-05', ''),
  ('dupa3', 'OUTSIDE','GROUND', 'DN100','0.43', '1.3', '4.12', '1982-11-12', FILE_READ('classpath:/db/said.jpg'));

INSERT INTO descriptions (measurement_id, name, status, comments)
VALUES (1, 'parametr pierwszy', 0, 'test comments')
, (1, 'parametr drugi', 1, 'test comments of the same obj')
, (2,'parametr pierwszy', 2, 'comments')
, (3, 'parametr 100 ', 1, 'chuj' );

INSERT INTO users (name, surname, username, password, role, created_at)
--trudne_haslo
VALUES ('bartosz', 'abramovvicz', 'dzik_programowania', '$2a$10$gyVqD2zBf8D2KcqGfbR1Ue.Lvs.31kUNYi1O6lwTHZTWZlbVdteOq', 'ADMIN', '2020-09-29')
--latwe_haslo
, ('lukasz', 'tarala', 'ogorek', '$2a$10$TAgQylfSaMTQHDDJwNX3oucdJmdKYBKKpvhm7eO3Od4ktq7s/BTeC', 'ADMIN', '2020-09-29')
--dupa123
, ('imie', 'nazwisko', 'nicknejm', '$2a$10$w/rMVnWXl/lUDibbq8Urc.aX/ePf7p0T1TxQTUDoRzuRU9ZUaZRGC', 'USER', '2020-09-29');