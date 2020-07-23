### Shell commands with MySQL 
+ DESC table;
+ SHOW CREATE TABLE customers\G
+ Clone table structure : CREATE TABLE new_customers LIKE customers;
### JSON commands
+ SELECT emp_no FROM emp_details WHERE details->>'$.address.pin'="560103";
+ SELECT JSON_CONTAINS(details->>'$.address.pin', "560103") FROM emp_details;
+ SELECT JSON_CONTAINS_PATH(details, 'one', "$.address.line1") FROM emp_details;
+ UPDATE 
    emp_details 
SET 
    details = JSON_SET(details, "$.address.pin", "560100", "$.nickname", "kai")
WHERE 
    emp_no = 1;

+  UPDATE emp_details SET details=JSON_INSERT(details, "$.address.pin", "560132", "$.address.line4", "A Wing") WHERE emp_no = 1;
+ UPDATE emp_details SET details=JSON_REPLACE(details, "$.address.pin", "560132", "$.address.line5", "Landmark") WHERE 
emp_no = 1;
+ SELECT JSON_KEYS(details) FROM emp_details WHERE emp_no = 1;



### Virtual column : 
+ ALTER TABLE employees ADD hire_date_year YEAR AS (YEAR(hire_date)) VIRTUAL;


### CTE 
+ WITH CTE AS 
    (SELECT year(from_date) AS year, SUM(salary) AS sum FROM salaries GROUP BY year) 
SELECT 
    q1.year, q2.year as next_year, q1.sum, q2.sum as next_sum, 100*(q2.sum-q1.sum)/q1.sum as pct FROM 
    CTE AS q1, 
    CTE AS q2 
WHERE 
    q1.year = q2.year-1;
+ CTEs can refer to other CTEs:

WITH d1 AS (SELECT ... FROM ...), d2 AS (SELECT ... FROM d1 ...) 
SELECT
 FROM d1, d2 ... 


+ Recursive query : 
WITH RECURSIVE cte (n) AS 
( SELECT 1 /* seed query */
  UNION ALL 
  SELECT n + 1 FROM cte WHERE n < 5 /* recursive query */
) 
SELECT * FROM cte;

+ Recursive CTE 
WITH RECURSIVE employee_paths (id, name, path) AS
(
 SELECT id, name, CAST(id AS CHAR(200))
 FROM employees_mgr
 WHERE manager_id IS NULL
 UNION ALL
 SELECT e.id, e.name, CONCAT(ep.path, ',', e.id)
 FROM employee_paths AS ep JOIN employees_mgr AS e
 ON ep.id = e.manager_id
)
SELECT * FROM employee_paths ORDER BY path;


### Config MySQL 
+ Using config file
+ Using global and session variables
+ Using parameters with startup script
+ Configuring the parameters
+ Changing the data directory