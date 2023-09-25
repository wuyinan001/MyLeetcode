# Write your MySQL query statement below
SELECT c.machine_id, ROUND(AVG(c.processing_time),3) AS processing_time
FROM
(
    SELECT a.machine_id, (b.timestamp-a.timestamp) AS processing_time
    FROM Activity a, Activity b
    WHERE a.machine_id=b.machine_id AND a.process_id=b.process_id
    AND a.activity_type='start' AND b.activity_type='end'
) c
GROUP BY c.machine_id