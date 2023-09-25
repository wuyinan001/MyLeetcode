# Write your MySQL query statement below
WITH t1
AS
(
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
),

t2
AS
(
    SELECT COUNT(*) AS numerator
    FROM Activity
    WHERE (player_id, event_date) IN
    (
        SELECT t1.player_id, DATE_ADD(t1.first_date,INTERVAL 1 DAY)
        FROM t1
    )
)

SELECT ROUND((SELECT numerator FROM t2)*1.0/COUNT(DISTINCT player_id),2) AS fraction
FROM Activity