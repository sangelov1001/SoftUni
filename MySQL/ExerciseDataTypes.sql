CREATE DATABASE `minions`;
USE `minions`;

CREATE TABLE `minions` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` INT 
);

CREATE TABLE `towns` (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL 
);

ALTER TABLE `minions`
ADD COLUMN `town_id`INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY  (`town_id`)
REFERENCES `towns`(`id`);

INSERT INTO `towns`
VALUES 
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO `minions`
VALUES
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

TRUNCATE  `minions`; 

DROP TABLE `minions`;
DROP TABLE `towns`;

CREATE TABLE `people` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` FLOAT(5, 2),
`weight` FLOAT(5, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT 
);

#ex.8 махаме primary key и създаваме нов
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`, `username`);

#ex.11/12
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(100) NOT NULL,
# създаваме си foreign key още при създаването на таблицата
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`middle_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`job_title` VARCHAR(20),
`salary` DECIMAL(10, 2),
`department_id` INT,
`hire_date` DATE,
`address_id` INT,
CONSTRAINT fk_employees_departments
FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`),
CONSTRAINT fk_employees_addresses
FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);

INSERT INTO `towns` (`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO `departments`(`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

# пишем 4 защото горе сме сетнали departments и неговото отговаря на id 4
INSERT INTO `employees`(`id`, `first_name`, `middle_name`, `last_name`, `job_title`, `salary`, `department_id`, `hire_date`, `address_id`)
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer',3500.00 , 4, '2013-02-01', NULL),
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 4000.00 , 1, '2004-03-02', NULL),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 525.25, 5, '2016-08-28', NULL),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 3000.00, 2, '2007-12-09', NULL),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 599.88, 3, '2016-08-28', NULL);

#ex 17
UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;

#ex 18
DELETE FROM `employees`
WHERE `id` = 1;

#EX7
CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(50) NOT NULL,
`password` VARCHAR(50) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_delelted` BOOLEAN
);

#ex 15
SELECT * FROM `towns`
ORDER BY `name`;

SELECT * FROM `departments`
ORDER BY `name`;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

#ex 16
SELECT `name` FROM `towns`
ORDER BY `name`;

SELECT `name` FROM `departments`
ORDER BY `name`;

SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;
