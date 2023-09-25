# Write your MySQL query statement below
SELECT c.product_id, ROUND(SUM(c.total_price)/SUM(units),2) AS average_price
FROM
(
    SELECT a.product_id, a.purchase_date, a.units, a.units*b.price AS total_price
    FROM UnitsSold a
    INNER JOIN Prices b
    ON a.product_id=b.product_id
    WHERE a.purchase_date BETWEEN b.start_date AND b.end_date
) c
GROUP BY c.product_id