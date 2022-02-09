#ex1
SELECT `department_id`, COUNT(*) AS 'Number of employees'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`, 'Number of employees';

#ex2
SELECT `department_id`, ROUND(AVG(`salary`), 2) AS 'Average salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

#ex3
SELECT `department_id`, ROUND(MIN(`salary`), 2) AS 'Min Salary'
FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800;

#ex4
SELECT COUNT(`id`) FROM `products`
WHERE `category_id` = 2 AND `price` > 8
GROUP BY `department_id`;

#ex5
SELECT `category_id`, 
ROUND(AVG(`price`), 2) AS 'Average Price',
ROUND(MIN(`price`), 2) AS 'Cheapest Product',
ROUND(MAX(`price`), 2) AS 'Most Expensive Product'
FROM `products`
GROUP BY `category_id`;

#ex1
SELECT COUNT(*) FROM `wizzard_deposits`;

#ex2
SELECT MAX(`magic_wand_size`) FROM `wizzard_deposits`;

#ex3
SELECT `deposit_group`, MAX(`magic_wand_size`) AS 'max_size'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `max_size`, `deposit_group`;

#ex4
SELECT `deposit_group`, AVG(`magic_wand_size`) AS 'avg_size'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `avg_size`
LIMIT 1;

#ex5
SELECT `deposit_group`, 
SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

#ex6
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;

#ex7
SELECT 
    `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM
    `wizzard_deposits`
WHERE
    `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

#ex8
SELECT 
    `deposit_group`,
    `magic_wand_creator`,
    MIN(`deposit_charge`) AS 'min_charge'
FROM
    `wizzard_deposits`
GROUP BY `deposit_group` , `magic_wand_creator`
ORDER BY `magic_wand_creator` , `deposit_group`;

#ex9
SELECT 
    (CASE
        WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
        WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
        ELSE '[61+]'
    END) AS `age_group`,
    COUNT(*) AS `wizz_count`
FROM
    `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;

#ex10
SELECT 
    LEFT(`first_name`, 1) AS `f_char`
FROM
    `wizzard_deposits`
WHERE
    `deposit_group` = 'Troll Chest'
GROUP BY `f_char`
ORDER BY `f_char`;

#ex11
SELECT 
    `deposit_group`,
    `is_deposit_expired`,
    AVG(`deposit_interest`) AS `avg_interest`
FROM
    `wizzard_deposits`
WHERE
    `deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group` , `is_deposit_expired`
ORDER BY `deposit_group` DESC , `is_deposit_expired`;

#ex12
SELECT `department_id`, MIN(`salary`) AS 'min_salary'
FROM `employees`
WHERE `department_id` IN(2, 5, 7) AND YEAR(`hire_date`) >= 2000
GROUP BY `department_id`
ORDER BY `department_id`;

#ex13
CREATE TABLE `hpe` AS 
SELECT * FROM `employees`
WHERE `salary` > 30000 AND `manager_id` != 42;

UPDATE `hpe` 
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) AS 'avg_salary'
FROM `hpe`
GROUP BY `department_id`
ORDER BY `department_id`;

#ex16
SELECT 
    e.`department_id`,
    (SELECT DISTINCT
            e2.`salary`
        FROM
            `employees` AS e2
        WHERE
            e2.`department_id` = e.`department_id`
        ORDER BY e2.`salary` DESC
        LIMIT 1 OFFSET 2) AS `third_high_salary`
FROM
    `employees` AS e
GROUP BY e.`department_id`
HAVING `third_high_salary` IS NOT NULL
ORDER BY e.`department_id`;

#ex17
SELECT e.`first_name`, e.`last_name`, e.`department_id` 
FROM `employees` AS e
WHERE e.`salary` > 
(
	SELECT AVG(e2.`salary`)
	FROM `employees` AS e2
	WHERE e2.`department_id` = e.`department_id`
) 
ORDER BY `department_id`, `employee_id`
LIMIT 10;

#ex15
SELECT `salary`, COUNT(`salary`) AS `count_salary`
FROM `employees`
WHERE `manager_id` IS NULL;