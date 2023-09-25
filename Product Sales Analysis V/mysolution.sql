# Write your MySQL query statement below
WITH cte
AS
(
SELECT a.user_id, a.quantity*b.price AS spending
FROM Sales a
LEFT JOIN Product b
ON a.product_id=b.product_id
)

SELECT user_id, SUM(spending) AS spending
FROM cte
GROUP BY user_id
ORDER BY spending DESC, user_id