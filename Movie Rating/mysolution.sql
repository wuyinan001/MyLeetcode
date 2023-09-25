# Write your MySQL query statement below
WITH t1
AS
(
    SELECT user_id, COUNT(*) AS num_movies
    FROM MovieRating
    GROUP BY user_id
),

t2
AS
(
    SELECT user_id
    FROM t1
    WHERE t1.num_movies=(SELECT MAX(t1.num_movies) FROM t1)
),

t3
AS
(
    SELECT name AS results
    FROM Users
    WHERE Users.user_id IN (SELECT * FROM t2)
    ORDER BY name
    LIMIT 1
),

t4
AS
(
    SELECT movie_id, AVG(rating) AS avg_rating
    FROM MovieRating
    WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY movie_id
),

t5
AS
(
    SELECT movie_id
    FROM t4
    WHERE avg_rating=(SELECT MAX(avg_rating) FROM t4)
),

t6
AS
(
    SELECT title AS results
    FROM Movies
    WHERE movie_id IN (SELECT * FROM t5)
    ORDER BY title
    LIMIT 1
)

SELECT *
FROM t3
UNION ALL
SELECT * 
FROM t6