# Write your MySQL query statement below
SELECT DISTINCT a.num AS ConsecutiveNums
FROM Logs a, Logs b, Logs c
WHERE a.num=b.num AND a.num=c.num AND a.id+1=b.id AND a.id+2=c.id