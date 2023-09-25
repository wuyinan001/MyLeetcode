# Write your MySQL query statement below
WITH t4
AS
(
    SELECT t1.*, t2.name, t3.title
    FROM MovieRating t1
    INNER JOIN Users t2
    ON t1.user_id=t2.user_id
    INNER JOIN Movies t3
    ON t1.movie_id=t3.movie_id
),

t5
AS
(
    SELECT name
    FROM t4
    GROUP BY user_id
    ORDER BY COUNT(*) DESC, name
    LIMIT 1
),

t6
AS
(
    SELECT title
    FROM t4
    WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY movie_id
    ORDER BY AVG(rating) DESC, title
    LIMIT 1
)

SELECT name AS results FROM t5
UNION ALL
SELECT title AS results FROM t6