#ex
SELECT `title` FROM `books`
WHERE substring(title, 1, 3) = 'The'
ORDER BY `id`; 

#ex
SELECT REPLACE(`title`, 'The', '***') 
FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;

#ex
SELECT ROUND(SUM(`cost`), 2)
FROM `books`;

#ex
SELECT CONCAT(`first_name`, ' ', `last_name`)
AS 'FULL Name',
timestampdiff(day, born, died) 
AS 'days_lived'
FROM `authors`;

#ex
SELECT `title` FROM `books`
WHERE `title` LIKE 'Harry Potter%'
ORDER BY `id`;

#ex1
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE SUBSTRING(`first_name`, 1, 2) = 'Sa'
# WHERE LEFT(`first_name`,2) = 'Sa'
# WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

#ex2
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

#ex3
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN(3, 10)
AND YEAR(`hire_date`)
BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

#ex4
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

#ex5
SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN(5, 6)
ORDER BY `name`;

#ex6
SELECT `town_id`, `name` 
FROM `towns`
WHERE LEFT(`name`, 1) IN ('M', 'K', 'B', 'E')
ORDER BY `name`;

#ex7
SELECT `town_id`, `name`
FROM `towns`
WHERE LEFT(`name`, 1) NOT IN ('R', 'B', 'D')
ORDER BY `name`;

#ex8
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name`
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

#ex9
SELECT `first_name`, `last_name`
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;

#ex10
SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%A%A%A'
ORDER BY `iso_code`;

#ex11
# взимаме substring на реката от 2 ри символ нататък
SELECT `peak_name`, `river_name`, 
LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS 'mix'
FROM `peaks`, `rivers`
WHERE RIGHT (`peak_name`, 1 ) = LEFT(`river_name`, 1)
ORDER BY `mix`;

#ex12
SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') 
FROM `games`
WHERE YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start`, `name`
LIMIT 50; 

#ex13
# с този substring искаме да отрежем от emaila локацията на @
# пишем + 1 за да вземе следващия символ след @
SELECT `user_name`, SUBSTRING(`email`, LOCATE('@', `email`) + 1)
AS 'email_provider'
FROM `users`
ORDER BY `email_provider`, `user_name`;

#ex14
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

#ex15
# така взимаме часа на start-а
SELECT `name`,
(
  CASE 
		WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
		WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
		ELSE 'Evening'
        END
) AS 'Part of the Day',
(
	CASE 
		WHEN `duration` < 4  THEN 'Extra Short' 
		WHEN `duration` < 7	 THEN 'Short' 
		WHEN `duration` < 11 THEN 'Long' 
		ELSE 'Extra Long'
        END
) AS 'Duration'
FROM `games`;

#ex16
SELECT `product_name`, `order_date`,
DATE_ADD(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM `orders`;