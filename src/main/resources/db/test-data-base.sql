INSERT INTO measurements (address, hydrant_type, hydrant_subtype, hydrant_diameter, measurement_date)
VALUES ('dupa', 'INSIDE', 'UNDEFINED', 'DN25', '2004-12-31'),
('test1', 'INSIDE', 'UNDEFINED', 'DN33', '2012-01-01'),
 ('dupa2', 'OUTSIDE','UNDERGROUND', 'DN80','2020-04-05'),
  ('dupa3', 'OUTSIDE','GROUND', 'DN100','1982-11-12');

INSERT INTO details (measurement_id, name, status, description)
VALUES (1, 'parametr pierwszy', 0, 'test description'), (1, 'parametr drugi', 1, 'test description of the same obj'), (2,'parametr pierwszy', 2, 'dupa');