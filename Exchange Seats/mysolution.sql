# Write your MySQL query statement below
SELECT *
FROM
(
    SELECT a.id, b.student
    FROM Seat a, Seat b
    WHERE a.id+1=b.id AND a.id%2!=0
    UNION
    SELECT a.id, b.student
    FROM Seat a, Seat b
    WHERE a.id-1=b.id AND a.id%2=0
    UNION
    SELECT id, student
    FROM Seat
    WHERE id=
    (
        SELECT MAX(id)
        FROM Seat
    ) AND id%2!=0
)t
ORDER BY t.id