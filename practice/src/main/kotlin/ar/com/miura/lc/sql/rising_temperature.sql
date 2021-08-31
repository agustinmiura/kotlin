# Write your MySQL query statement below
SELECT
    w0.id as 'Id'
    FROM Weather w0 JOIN Weather w1
    ON
        DATEDIFF(w0.recordDate, w1.recordDate) = 1
    AND
        w0.temperature > w1.temperature