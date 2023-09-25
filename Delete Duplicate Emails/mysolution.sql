# Write your MySQL query statement below
WITH t1
AS
(
    SELECT MIN(id), email
    FROM Person
    GROUP BY email
    HAVING COUNT(*)>1
    UNION ALL
    SELECT id, email
    FROM Person
    GROUP BY email
    HAVING COUNT(*)=1
)
DELETE FROM Person
WHERE (id, email) NOT IN
(SELECT * FROM t1)