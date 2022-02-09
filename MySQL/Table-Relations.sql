#ex1
CREATE TABLE `mountains` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `peaks`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `mountain_id` INT,
    CONSTRAINT `fk_peaks_mountains`
    FOREIGN KEY(`mountain_id`)
    REFERENCES `mountains`(`id`)
);

#ex2 -> пример за Join
SELECT v.`driver_id`, v.`vehicle_type`, CONCAT(c.`first_name`, ' ', c.`last_name`) AS 'driver_name'
FROM `campers` c
JOIN `vehicles` AS v ON v.`driver_id` = c.`id`;

#ex4
CREATE TABLE `mountains` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `peaks`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `mountain_id` INT,
    CONSTRAINT 
    FOREIGN KEY(`mountain_id`)
    REFERENCES `mountains`(`id`)
    ON DELETE CASCADE
   );
   
#ex3 
# преди да JOIN-нем по дадени редове така залепяме двете таблици с
# всички колони в тях за да видим коя колона ще залепим от едната за другата
SELECT r.`starting_point`, r.`end_point`, r.`leader_id`,
CONCAT(c.`first_name`, ' ', c.`last_name`)
FROM `routes` AS r
JOIN `campers` AS c ON r.`leader_id` = c.`id`;

#ex5
CREATE TABLE `clients` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`client_name` VARCHAR(50)
);


CREATE TABLE `projects` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`client_id` INT,
`project_lead_id` INT,
CONSTRAINT fk_clients
FOREIGN KEY(`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `employees` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`project_id` INT,
CONSTRAINT fk_projects
FOREIGN KEY (`project_id`)
REFERENCES `projects`(`id`)
);

ALTER TABLE `projects` ADD
CONSTRAINT fk_projects1
FOREIGN KEY (`project_lead_id`)
REFERENCES `employees`(`id`);

#ex1
CREATE DATABASE test;
USE test;

CREATE TABLE `passports` (
`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
`passport_number` VARCHAR(20) UNIQUE
);

ALTER TABLE `passports` AUTO_INCREMENT = 101;
INSERT INTO `passports`(`passport_number`)
VALUES
('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

CREATE TABLE `people` (
	`person_id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(40),
    `salary` DECIMAL(10,2),
    `passport_id` INT UNIQUE,
    CONSTRAINT fk_people_passports
    FOREIGN KEY (`passport_id`)
    REFERENCES `passports`(`passport_id`) 
);
	
    INSERT INTO `people`
    VALUES
    (1, 'Roberto', 43300.00, 102),
    (2, 'Tom', 56100.00, 103),
    (3, 'Yana', 60200.00, 101);
    
#ex2
CREATE TABLE `manufactures` (
	`manufactorer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `established_on` DATE
);

INSERT INTO `manufactures`(`name`, `established_on`)
VALUES
('BMW', 01/03/1916),
('Tesla', 01/01/2003),
('Lada', '1966-05-01');

CREATE TABLE `models` (
	`model_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `manufactorer_id` INT,
    CONSTRAINT fk_models_manufacturers
    FOREIGN KEY (`manufactorer_id`)
    REFERENCES `manufactures`(`manufactorer_id`)
);

INSERT INTO `models`
VALUES
(101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

#ex3
CREATE TABLE `students` (
	`student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);

INSERT INTO `students`(`name`)
VALUES
('Mila'),
('Toni'),
('Ron');

CREATE TABLE `exams` (
	`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);

ALTER TABLE `exams` AUTO_INCREMENT = 101;
INSERT INTO `exams`(`name`)
VALUES
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

#mapping table
CREATE TABLE `students_exams` (
	`student_id` INT,
    `exam_id` INT,
    CONSTRAINT pk_students_exams
    # композитен ключ
    PRIMARY KEY (`student_id`, `exam_id`),
    CONSTRAINT fk_students_exams_students
    FOREIGN KEY (`student_id`)
    REFERENCES `students`(`student_id`),
    CONSTRAINT fk_students_exams_exams
    FOREIGN KEY (`exam_id`)
    REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students_exams`
VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

#ex4
CREATE TABLE `teachers` (
	`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `manager_id` INT
);
ALTER TABLE `teachers` AUTO_INCREMENT = 101;
INSERT INTO `teachers`(`name`, `manager_id`)
VALUES
('John', NULL),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark', 101),
('Greta', 101);
 
 ALTER TABLE `teachers`
 ADD CONSTRAINT fk_teachers_managers
 FOREIGN KEY (`manager_id`)
 REFERENCES `teachers`(`teacher_id`);
 
 #ex5
 CREATE TABLE `cities` (
	`city_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
 );
 
 CREATE TABLE `customers` (
	`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT,
    CONSTRAINT fk_customers_cities
    FOREIGN KEY(`city_id`)
    REFERENCES `cities`(`city_id`)
 );
 
 CREATE TABLE `orders` (
	`order_id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT,
    CONSTRAINT fk_orders_customers
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers`(`customer_id`)
 );
 
 CREATE TABLE `item_types` (
	`item_type_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
 );
 
 CREATE TABLE `items` (
	`item_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `item_type_id` INT,
    CONSTRAINT fk_items_items_types
    FOREIGN KEY (`item_type_id`)
    REFERENCES `item_types`(`item_type_id`)
 );

 CREATE TABLE `order_items` (
	`order_id` INT,
    `item_id` INT,
    CONSTRAINT pk_order_items
    PRIMARY KEY(`order_id`, `item_id`),
    CONSTRAINT fk_order_items_orders
    FOREIGN KEY (`order_id`)
    REFERENCES `orders`(`order_id`),
    CONSTRAINT fk_order_items_items
    FOREIGN KEY (`item_id`)
    REFERENCES `items`(`item_id`)
);

#ex9
SELECT m.`mountain_range`, p.`peak_name`, p.`elevation` 
FROM `mountains` AS m
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE m.`mountain_range` = 'Rila'
ORDER BY p.`elevation` DESC;