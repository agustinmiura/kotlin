# Write your MySQL query statement below
SELECT DISTINCT
l0.Num as ConsecutiveNums
FROM
 Logs l0,
 Logs l1,
 Logs l2
WHERE
    l1.Id = (l0.Id-1) AND
    l2.Id = (l1.id-1) AND
    l0.Num = l1.Num AND
    l1.Num = l2.Num
