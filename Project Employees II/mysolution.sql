# Write your MySQL query statement below
WITH t1
AS
(
    SELECT project_id, COUNT(*) AS total_employees
    FROM Project
    GROUP BY project_id
)

SELECT t1.project_id
FROM t1
WHERE t1.total_employees IN
(
    SELECT MAX(total_employees)
    FROM t1
)