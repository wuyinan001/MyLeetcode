# Write your MySQL query statement below
SELECT a.customer_id, COUNT(*) AS count_no_trans
FROM Visits a
LEFT JOIN Transactions b
ON a.visit_id=b.visit_id
WHERE ISNULL(b.amount)
GROUP BY a.customer_id