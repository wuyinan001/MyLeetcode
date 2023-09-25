# Write your MySQL query statement below

WITH t1
AS
(
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
)

SELECT a.visited_on, SUM(b.amount) AS amount, 
ROUND(SUM(b.amount)/7,2) AS average_amount
FROM t1 a, t1 b
WHERE DATEDIFF(a.visited_on,b.visited_on) BETWEEN 0 AND 6
AND a.visited_on>=(SELECT MIN(visited_on) FROM Customer)+6
GROUP BY a.visited_on
ORDER BY a.visited_on