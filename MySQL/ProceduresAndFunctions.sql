#ex1
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
		SELECT e.first_name, e.last_name 
        FROM employees AS e
        WHERE e.salary > 35000
        ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above_35000();

#ex2
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary_limit DOUBLE(19, 4))
BEGIN
	SELECT e.first_name, e.last_name
    FROM employees AS e
    WHERE e.salary >= salary_limit
    ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above(45000);

#ex3
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(town_name_start TEXT)
	BEGIN 
		SELECT t.name 
        FROM towns AS t
        WHERE t.name LIKE CONCAT(town_name_start, '%')
        ORDER BY t.name;
    END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');


