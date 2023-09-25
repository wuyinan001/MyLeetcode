# Write your MySQL query statement below
SELECT session_id
FROM Playback
WHERE session_id!=ALL
(
    SELECT a.session_id
    FROM Playback a
    LEFT JOIN Ads b
    ON a.customer_id=b.customer_id
    WHERE b.timestamp BETWEEN a.start_time AND a.end_time
)