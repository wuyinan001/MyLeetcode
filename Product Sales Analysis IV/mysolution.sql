# Write your MySQL query statement below

WITH c AS
(
    SELECT a.user_id, a.product_id, SUM(a.quantity)*b.price AS total_price
    FROM Sales a
    INNER JOIN Product b
    ON a.product_id=b.product_id
    GROUP BY a.user_id, a.product_id
),
d AS
(
    SELECT user_id, MAX(total_price) AS max_price
    FROM c
    GROUP BY user_id
)
SELECT user_id, product_id
FROM c
WHERE (user_id, total_price) IN
(
    SELECT *
    FROM d
)