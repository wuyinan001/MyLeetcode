# Write your MySQL query statement below
SELECT employee_id, department_id
FROM Employee
WHERE primary_flag='Y'
GROUP BY employee_id
UNION
SELECT employee_id, department_Id
FROM Employee
GROUP BY employee_id
HAVING COUNT(*)=1