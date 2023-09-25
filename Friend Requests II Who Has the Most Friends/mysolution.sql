# Write your MySQL query statement below
WITH t1
AS
(
    SELECT requester_id AS id, COUNT(*) AS num
    FROM RequestAccepted
    GROUP BY requester_id
),

t2
AS
(
    SELECT accepter_id AS id, COUNT(*) AS num
    FROM RequestAccepted
    GROUP BY accepter_id
),

t3
AS
(
    SELECT *
    FROM t1
    UNION ALL
    SELECT *
    FROM t2
),

t4
AS
(
    SELECT id, SUM(num) AS num
    FROM t3
    GROUP BY id
)

SELECT id, num
FROM t4
ORDER BY num DESC
LIMIT 1