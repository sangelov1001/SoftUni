#ex.1
SELECT * FROM `departments`
ORDER BY `department_id`;

#ex2
SELECT `name` FROM `departments`
ORDER BY `department_id`;

#ex3
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

#ex4
SELECT `first_name`, `middle_name`, `last_name` FROM `employees`;
#WHERE `middle_name` IS NULL;

#ex5
SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg')
AS 'full_email_address'
FROM `employees`;

#ex6
SELECT DISTINCT `salary` FROM `employees`
ORDER BY `employee_id`;

#ex7
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

#ex8
SELECT `first_name`, `last_name`, `salary`
FROM `employees`
WHERE `salary` >= 20000 AND `salary` <= 30000
ORDER BY `employee_id`;

#ex9
SELECT CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) 
AS 'Full Name'
FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);

#ex10
SELECT `first_name`, `last_name` FROM `employees`
WHERE `manager_id` IS NULL;

#ex11
SELECT `first_name`, `last_name`, `salary`
FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

#ex12
SELECT `first_name`, `last_name`
FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

#ex13
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` != 4;

#ex14
SELECT * FROM `employees`
ORDER BY `salary` DESC, 
`first_name`,
`last_name` DESC,
`middle_name`;

#ex15
CREATE VIEW `v_employees_salaries` AS 
SELECT `first_name`, `last_name`, `salary` 
FROM `employees`;
SELECT * FROM `v_employees_salaries`;

#ex16
CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`)
AS 'full_name', `job_titile`
FROM `employees`;
SELECT * FROM `v_employees_job_titles`;

#ex17
SELECT DISTINCT `job_title` 
FROM `employees`;

#ex18
SELECT * FROM `projects`
ORDER BY `start_date`, `name`, `project_id`
LIMIT 10;

#ex20
SELECT * FROM `employees`;
UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1, 2, 4, 11);

#ex21
SELECT `peak_name` FROM `peaks`
ORDER BY `peak_name` ASC;

#ex22
SELECT `country_name`, `continent_code`, `population`
FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC, `country_name`
LIMIT 30;

#ex23
SELECT `country_name`, `country_code`, `currency_code`,
IF (`currency_code` = 'EUR', 'Euro', 'Not Euro') AS 'currency'
FROM `countries`
ORDER BY `country_name`; 