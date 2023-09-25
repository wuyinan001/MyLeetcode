# Write your MySQL query statement below
WITH t1
AS
(
    SELECT reports_to AS employee_id, COUNT(*) AS reports_count, ROUND(AVG(age)) AS average_age
    FROM Employees
    WHERE NOT ISNULL(reports_to)
    GROUP BY reports_to
)

SELECT t1.employee_id, Employees.name, t1.reports_count, t1.average_age
FROM t1
INNER JOIN Employees
ON t1.employee_id=Employees.employee_id
ORDER BY t1.employee_id