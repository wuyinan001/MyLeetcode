# Write your MySQL query statement below
SELECT CASE WHEN COUNT(*)=2 THEN MIN(salary) ELSE NULL END AS SecondHighestSalary
FROM
(
SELECT salary
FROM Employee
GROUP BY salary
ORDER BY salary DESC
LIMIT 2
)t