#CREATE DATABASE Human_Friends;
USE Human_Friends;

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    birth_day DATE NOT NULL,
    commands VARCHAR(255)
);
ALTER TABLE pets AUTO_INCREMENT=101;

INSERT INTO pets (name, type, birth_day, commands) VALUES
('Rupert', 'Dog', '2023-01-01', 'Sit, Stay, Fetch'),
('Sunny', 'Cat', '2019-05-15', 'Sit, Pounce'),
('Funken', 'Hamster', '2024-03-10', 'Roll, Hide'),
('Oliver', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
('ZZTop', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
('Super', 'Hamster', '2023-08-01', 'Roll, Spin'),
('Faton', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
('Tom', 'Cat', '2022-06-30', 'Meow, Scratch, Jump');

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    birth_day DATE NOT NULL,
    commands VARCHAR(255)
);
ALTER TABLE pack_animals AUTO_INCREMENT=201;

INSERT INTO pack_animals (name, type, birth_day, commands) VALUES
('Wind', 'Horse', '2024-07-21', 'Trot, Canter, Gallop'),
('Ice', 'Camel', '2016-11-03', 'Walk, Carry Load'),
('Golem', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
('Bob', 'Horse', '2023-05-05', 'Trot, Canter'),
('Jon', 'Camel', '2018-12-12', 'Walk, Sit'),
('Kaput', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
('Liza', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
('Nord', 'Camel', '2022-08-14', 'Walk, Run');

SELECT * FROM pets;
SELECT * FROM pack_animals;

DELETE FROM pack_animals
WHERE type = 'Camel';

SELECT * FROM pack_animals;

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    birth_day DATE NOT NULL,
    commands VARCHAR(255),
    age_of_animals VARCHAR(255) NOT NULL
);

INSERT INTO young_animals (id, name, type, birth_day, commands, age_of_animals)
SELECT 
	id, name, type, birth_day, commands,
	CONCAT(TIMESTAMPDIFF(YEAR, birth_day, curdate()),
    " year(s)  ",
    TIMESTAMPDIFF(MONTH, birth_day, curdate()) -
    (TIMESTAMPDIFF(YEAR, birth_day, curdate())*12), ' month(s)')
FROM 
	pets
WHERE
	TIMESTAMPDIFF(MONTH, birth_day, curdate())/12 > 1
    AND 
	TIMESTAMPDIFF(MONTH, birth_day, curdate())/12 < 3
UNION ALL SELECT 
	id, name, type, birth_day, commands,
	CONCAT(TIMESTAMPDIFF(YEAR, birth_day, curdate()),
    " year(s)  ",
    TIMESTAMPDIFF(MONTH, birth_day, curdate()) -
    (TIMESTAMPDIFF(YEAR, birth_day, curdate())*12), ' month(s)') 
FROM pack_animals    
WHERE
	TIMESTAMPDIFF(MONTH, birth_day, curdate())/12 > 1
    AND 
	TIMESTAMPDIFF(MONTH, birth_day, curdate())/12 < 3;

SELECT * FROM young_animals;

DROP TABLE IF EXISTS summary_table;
CREATE TABLE summary_table (
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    birth_day DATE NOT NULL,
    commands VARCHAR(255),
    age_of_animals VARCHAR(255),
    original_table VARCHAR(255) NOT NULL
);

INSERT INTO summary_table (
id, name, type, birth_day, commands, age_of_animals, original_table)
SELECT 
	id, name, type, birth_day, commands, NULL, 'pets'
FROM 
	pets
UNION ALL SELECT
	id, name, type, birth_day, commands, NULL, 'pack_animals'
FROM pack_animals
UNION ALL SELECT
	id, name, type, birth_day, commands, age_of_animals, 'young_animals'
FROM young_animals;

SELECT * FROM summary_table


