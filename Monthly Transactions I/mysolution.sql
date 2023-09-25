# Write your MySQL query statement below
WITH t1
AS
(
    SELECT id, country, state, amount, IF(state='approved',amount,0) AS approved_amount, DATE_FORMAT(trans_date,'%Y-%m') AS trans_date
    FROM Transactions
)

SELECT t1.trans_date AS month, t1.country, COUNT(*) AS trans_count,
SUM(state='approved') AS approved_count, SUM(t1.amount) AS trans_total_amount,
SUM(t1.approved_amount) AS approved_total_amount
FROM t1
GROUP BY t1.country, t1.trans_date