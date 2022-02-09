#ex1
SELECT e.`employee_id`, CONCAT(`first_name`, ' ', `last_name`) AS 'full_name', d.`department_id`, d.`name`
FROM `employees` AS e
JOIN `departments` AS d
ON d.`manager_id` = e.`employee_id`
ORDER BY e.`employee_id`
LIMIT 5;

#ex4
SELECT COUNT(e.`employee_id`) AS 'count'
FROM `employees` AS e
WHERE e.`salary` > (SELECT AVG(`salary`) AS 'average_salary' FROM `employees`);

#ex2
SELECT t.`town_id`, t.name, `address_text`
FROM `addresses` AS a
JOIN `towns` AS t
ON t.`town_id` = a.`town_id`
WHERE t.`name` IN ('Sofia', 'San Francisko', 'Carnation')
ORDER BY t.`town_id`, a.`address_id`;

#ex3
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, e.`department_id`, `salary`
FROM `employees` AS e
WHERE `manager_id` IS NULL;

#ex1
SELECT e.`employee_id`, e.`job_title`, a.`address_id`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY a.`address_id`
LIMIT 5;

#ex2
SELECT e.`first_name`, e.`last_name`, t.`name`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name`, e.`last_name`
LIMIT 5;

#ex3
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;

#ex4 same as ex3 with diff explain and sort
SELECT e.`employee_id`,e.`first_name`, e.`salary`, d.`name`
FROM `employees` AS e
JOIN `departments` AS d
USING(`department_id`)
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

#ex5
SELECT e.`employee_id`, e.`first_name`
FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
WHERE ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

#EX6
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE DATE(e.`hire_date`) > '1999-01-01'
AND d.`name` IN ('Sales', 'Finance')
ORDER BY e.`hire_date`;

#ex7
SELECT e.`employee_id`, e.`first_name`, p.`name`
FROM `employees` AS e
JOIN `employees_projects` ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` p
ON p.`project_id` = ep.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13'
AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;

#ex8
SELECT e.`employee_id`, e.`first_name`, 
IF(YEAR(p.`start_date`) > 2004, NULL, p.`name`) AS `p_name`
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON ep.`employee_id` = e.`employee_id`
JOIN `projects` AS p
ON p.`project_id` = ep.`project_id`
WHERE e.`employee_id` = 24
ORDER BY `p_name`;

#ex10
SELECT e.`employee_id`, 
CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `e_name`,
CONCAT_WS(' ',m.`first_name`, m.`last_name`) AS `m_name`,
d.`name`
FROM `employees` AS e
JOIN `employees` AS m
ON e.`manager_id` = m.`employee_id`
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;

#EX11
# тук не ни трябва JOIN защото всичко ни е в таблицата `employees`
SELECT AVG(`salary`) AS `s_avg`
FROM `employees`
GROUP BY `department_id`
ORDER BY `s_avg`
LIMIT 1;

#ex12
SELECT c.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`
JOIN `mountains` AS m
ON mc.`mountain_id` = m.`id`
JOIN  `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE c.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

#13
SELECT mc.`country_code`, COUNT(m.`id`) AS `m_count`
FROM `mountains` AS m
JOIN `mountains_countries` AS mc
ON mc.`mountain_id` = m.`id`
WHERE mc.`country_code` IN ('BG', 'RU', 'US')
GROUP BY mc.`country_code`
ORDER BY `m_count` DESC
LIMIT 3;

#ex16
SELECT COUNT(*)
FROM `countries` AS c
WHERE c.`country_code` NOT IN 
(SELECT `country_code` FROM `mountains_countries`);

#EX17
SELECT c.`country_name`,MAX(p.`elevation`) AS `m_elevation`, 
MAX(r.`length`) AS `m_length`
FROM `countries` AS c
JOIN `countries_rivers` AS cr
ON cr.`country_code` = c.`country_code`
JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`
JOIN `mountains` AS m
ON mc.`mountain_id` = m.`id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
GROUP BY c.`country_code`
ORDER BY `m_elevation` DESC, `m_length` DESC, c.`country_name`
LIMIT 5;

#ex15 ----
SELECT `continent_code`, `currency_code`, COUNT(`country_name`) AS `currency_usage`
FROM `countries` AS c
GROUP BY `continent_code`, `currency_code`
HAVING `currency_usage` = (
	SELECT COUNT(`country_code`) AS `coun`
    FROM `countries` AS c1
	WHERE c.`continent_code` = c.`continent_code`
    GROUP BY `currency_code`
    ORDER BY `coun` DESC
    LIMIT 1
) AND `currency_usage` > 1
ORDER BY `continent_code`, `currency_code`;

#ex14
SELECT c.`country_name`, r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON r.`id` =cr.`river_id`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;