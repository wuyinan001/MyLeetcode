# Write your MySQL query statement below
SELECT *
FROM Users
WHERE LENGTH(mail)>13 AND RIGHT(mail,13)='@leetcode.com'
AND SUBSTRING(mail,1,LENGTH(mail)-13) regexp '^[a-zA-Z0-9-_.]+$'
AND SUBSTRING(mail,1,1) regexp '^[a-zA-Z]+$'