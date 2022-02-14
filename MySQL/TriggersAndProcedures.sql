#ex1
DELIMITER ###
CREATE FUNCTION udf_count_emplo_in_city(city_name VARCHAR(100))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN
	(SELECT COUNT(*)
	FROM `towns` AS t
	LEFT JOIN `addresses` AS a 
	ON t.`town_id` = a.`town_id`
	LEFT JOIN `employees` AS e 
	ON e.`address_id` = a.`address_id`
	WHERE t.`name` = city_name);
END
###

# -> използваме си готовата фукнция навсякъде
SELECT udf_count_emplo_in_city('Monroe');

#ex2
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(100))
BEGIN
	UPDATE `employees` AS e
	RIGHT JOIN `departments` AS d
	ON e.`department_id` = d.`department_id`
	SET `salary` = salary *1.05
	WHERE d.`name` = 'Sales';
END
$$
# testing stored procedure
CALL usp_raise_salaries('Sales');


#ex3
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(`user_id` INT) 
BEGIN
	START TRANSACTION;
	IF( (SELECT COUNT(*) FROM employees WHERE employee_id = user_id) > 0)
    THEN
    UPDATE employees SET salary = salary * 1.05 WHERE employee_id = user_id;
    COMMIT;
    ELSE ROLLBACK;
    END IF;
    
END
$$

CALL upd_promote(1);

#ex4
CREATE TABLE deleted_employees(
	`employee_id` INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `middle_name` VARCHAR(50) DEFAULT NULL,
    `job_title` VARCHAR(50) NOT NULL,
    `department_id` INT(10) NOT NULL,
	`salary` DECIMAL(19,4) NOT NULL
);

CREATE TRIGGER tr_deleted_employees
AFTER DELETE 
ON employees
FOR EACH ROW 
BEGIN
	INSERT INTO deleted_employees(first_name, last_name, middle_name, 
									job_title, department_id, salary)
      VALUES(OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END;

#ex4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name TEXT)
BEGIN
		SELECT e.first_name, e.last_name FROM employees AS e
		JOIN addresses AS a 
        ON e.address_id = a.address_id
        JOIN towns AS t
        ON t.town_id = a.town_id
        WHERE t.name = town_name
        ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');

#ex6
-- другия вариант е в една процедура с OR и AND да си правим проверки дали е в low avg или high
CREATE FUNCTION ufn_get_salary_level (salary DOUBLE(19, 4))
RETURNS VARCHAR(7)
	 RETURN (CASE
				WHEN salary < 30000 THEN 'Low'
                WHEN salary < 50000 THEN 'Average'
                ELSE 'High'
			END);

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
	SELECT e.first_name, e.last_name 
    FROM employees AS e
    WHERE ufn_get_salary_level(e.salary) = salary_level
    ORDER BY e.first_name DESC, e.last_name DESC;
END $$
DELIMITER ;

#ex9
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(money DOUBLE(19, 4))
BEGIN
		SELECT ah.first_name, ah.last_name FROM account_holders AS ah
		RIGHT JOIN 
        accounts AS a 
        ON ah.id = a.account_holder_id
        GROUP BY ah.id
        HAVING SUM(balance) > money
        ORDER BY ah.id;
END $$
DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);

#ex7
DELIMITER $$
CREATE PROCEDURE ufn_is_word_comprised(set_of_letter VARCHAR(50), word VARCHAR(50))
RETURNS BIT
RETURN word REGEXP(concat('^[', set_of_letter, ']+$'));
SELECT ufn_is_word_comprised
DELIMITER ;

#ex10
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19,4), interest_rate DECIMAL(19,4), years INT)
RETURNS DECIMAL(19,4)
BEGIN
	RETURN initial_sum * POW((1 + interest_rate), years);
END $$
DELIMITER ;

#11
DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account (account_id INT , interest_rate DECIMAL(19, 4))
BEGIN 
	SELECT 	a.id AS 'account_id',
			ah.first_name, 
            ah.last_name, 
            a.balance AS 'current_balance',
            ufn_calculate_future_value(a.balance, interest_rate, 5) AS 'balance_in_5_years'
    FROM account_holders AS ah
    JOIN accounts as a
    ON ah.id = a.account_holder_id
    WHERE a.id = account_id;
END $$
DELIMITER ;

CALL usp_calculate_future_value_for_account(1, 0.1);

#ex15
CREATE TABLE `logs` (
	`log_id` INT PRIMARY KEY AUTO_INCREMENT,
    `account_id` INT NOT NULL,
    `old_sum` DECIMAL(19, 4) NOT NULL,
    `new_sum` DECIMAL(18, 4) NOT NULL
);
DELIMITER $$
CREATE TRIGGER tr_balance_updated
AFTER UPDATE ON accounts
FOR EACH ROW 
BEGIN
	IF OLD.balance <> NEW.balance THEN 
    # този ИНСЕРТ пълни таблицата logs в колоните account_id, old_sum, new_sum
    INSERT INTO `logs` (account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
    END IF;
END $$
DELIMITER ;

#ex16
CREATE TABLE notification_emails (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `recipent` INT NOT NULL,
    `subject` VARCHAR(60) NOT NULL,
    `body` VARCHAR(255) NOT NULL
    );
    
    
DELIMITER $$
CREATE TRIGGER tr_notifications_emails
# за AFTER отговаря NEW за Before отговаря OLD
# всеки път когаго запишем нещо в logs се изпълнява тригера
AFTER INSERT ON `logs` 
FOR EACH ROW 
BEGIN
	INSERT INTO notification_emails(`recipient`, `subject`, `body`)
    VALUES (
		NEW.account_id,
        CONCAT('Balance change for account: ', NEW.account_id),
        CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), ' your balance changed from '),
				ROUND(NEW.old_sum, 2), ' to ', ROUND(NEW.new_sum, 2), '.'
			);
END $$
DELIMITER ;