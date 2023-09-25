# Write your MySQL query statement below
WITH t0
AS
(
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),

t1
AS
(
    SELECT visited_on, COUNT(*) OVER(ORDER BY visited_on) AS num, SUM(amount) OVER(ORDER BY visited_on) AS cum
    FROM t0
    UNION
    SELECT DATE_SUB(visited_on, INTERVAL 1 DAY) AS visited_on, 0 AS num, 0 AS cum
    FROM t0
    WHERE visited_on=
    (
        SELECT MIN(visited_on)
        FROM t0
    )
)

SELECT a.visited_on, a.cum-b.cum AS amount, 
ROUND((a.cum-b.cum)/(a.num-b.num),2) AS average_amount
FROM t1 a, t1 b
WHERE a.num>=7 AND b.visited_on=DATE_SUB(a.visited_on, INTERVAL 7 DAY)