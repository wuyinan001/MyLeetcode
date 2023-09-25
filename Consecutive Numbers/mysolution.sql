# Write your MySQL query statement below
SELECT DISTINCT t1.num AS ConsecutiveNums
FROM Logs t1
WHERE ((SELECT t2.num FROM Logs t2 WHERE t2.id=t1.id-1)=t1.num)
AND ((SELECT t3.num FROM Logs t3 WHERE t3.id=t1.id-2)=t1.num)