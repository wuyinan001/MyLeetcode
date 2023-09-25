# Write your MySQL query statement below
SELECT a.user_id, IFNULL(b.ratio,0.0) AS confirmation_rate 
FROM Signups a
LEFT JOIN
(
    SELECT user_id, ROUND(SUM(action='confirmed')*1.0/COUNT(*),2) AS ratio
    FROM Confirmations 
    GROUP BY user_id
) b
ON a.user_id=b.user_id