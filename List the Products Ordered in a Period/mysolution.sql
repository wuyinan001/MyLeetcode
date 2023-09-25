# Write your MySQL query statement below
SELECT b.product_name, SUM(a.unit) AS unit
FROM Orders a
LEFT JOIN Products b
ON a.product_id=b.product_id
WHERE a.order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY a.product_id
HAVING SUM(a.unit)>=100