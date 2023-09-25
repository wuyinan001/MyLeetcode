# Write your MySQL query statement below

WITH t1
AS
(
    SELECT player_id
    FROM Activity
    WHERE (player_id, event_date)
    IN
    (
        SELECT player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) AS second_date
        FROM Activity
        GROUP BY player_id
    )
)

SELECT ROUND((SELECT COUNT(*) FROM t1)/(SELECT COUNT(DISTINCT player_id) FROM Activity),2) AS fraction