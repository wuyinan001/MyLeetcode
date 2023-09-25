# Write your MySQL query statement below
WITH t1
AS
(
    SELECT id, country, state, amount, DATE_FORMAT(trans_date,'%Y-%m') AS trans_date
    FROM Transactions
)

SELECT t1.trans_date AS month, t1.country, COUNT(*) AS trans_count,
SUM(state='approved') AS approved_count, SUM(t1.amount) AS trans_total_amount,
SUM(
    CASE
        WHEN state='approved' THEN t1.amount
        ELSE 0
    END
) AS approved_total_amount
FROM t1
GROUP BY t1.country, t1.trans_date