# Write your MySQL query statement below
WITH stu_sub
AS
(
    SELECT a.student_id, a.student_name, b.subject_name
    FROM Students a
    CROSS JOIN Subjects b
),

exam_stat
AS
(
    SELECT student_id, subject_name, COUNT(*) AS number_exams
    FROM Examinations 
    GROUP BY student_id, subject_name
)

SELECT a.student_id, a.student_name, a.subject_name, IFNULL(b.number_exams,0) AS attended_exams
FROM stu_sub a
LEFT JOIN exam_stat b
ON a.student_id=b.student_id AND a.subject_name=b.subject_name
ORDER BY a.student_id, b.subject_name