# Write your MySQL query statement below
SELECT t1.month, t1.country, SUM(CASE WHEN state='approved' THEN 1 ELSE 0 END) AS approved_count, SUM(CASE WHEN state='approved' THEN t1.amount ELSE 0 END) AS approved_amount,
SUM(CASE WHEN state='back' THEN 1 ELSE 0 END) AS chargeback_count, SUM(CASE WHEN state='back' THEN t1.amount ELSE 0 END) AS chargeback_amount
FROM 
(
    SELECT DATE_FORMAT(chargebacks.trans_date, "%Y-%m") AS month, country, "back" AS state, amount
    FROM chargebacks
    JOIN transactions ON chargebacks.trans_id = transactions.id
    UNION ALL
    SELECT DATE_FORMAT(transactions.trans_date, "%Y-%m") AS month, country, state, amount
    FROM transactions
    WHERE state = "approved"
)t1
GROUP BY t1.month, t1.country