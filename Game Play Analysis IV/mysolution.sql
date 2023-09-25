# Write your MySQL query statement below

WITH 
t0
AS
(
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
)
,

t1
AS
(
    SELECT DISTINCT a.player_id
    FROM Activity a, Activity b
    WHERE a.player_id=b.player_id AND DATE_ADD(a.event_date,INTERVAL 1 DAY)=b.event_date
    AND a.event_date=(SELECT first_login FROM t0 WHERE a.player_id=t0.player_id)
),

t2
AS
(
    SELECT DISTINCT player_id
    FROM Activity
)

SELECT ROUND((SELECT COUNT(*) FROM t1)/(SELECT COUNT(*) FROM t2),2) AS fraction
