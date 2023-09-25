# Write your MySQL query statement below
SELECT t.person_name
FROM
(
    SELECT *, SUM(weight) OVER(ORDER BY turn) AS cum_weight
    FROM Queue
) t
WHERE t.cum_weight<=1000
ORDER BY t.turn DESC 
LIMIT 1
