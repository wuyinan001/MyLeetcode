# Write your MySQL query statement below
WITH t3 AS
(
    SELECT t1.project_id, t1.employee_id, t2.experience_years
    FROM Project t1
    LEFT JOIN Employee t2
    ON t1.employee_id=t2.employee_id
),

t4 AS
(
    SELECT project_id, MAX(experience_years) AS max_years
    FROM t3
    GROUP BY project_id
)

SELECT project_id, employee_id
FROM t3
WHERE (project_id, experience_years) IN
(
    SELECT *
    FROM t4
)