# Write your MySQL query statement below
#https://leetcode.com/problems/triangle-judgement/submissions/
SELECT
x as x,
y as y,
z as z,
(CASE WHEN
    ((x+y>z) AND (x+z>y) AND (y+z>x)) = 1  THEN "Yes"
    ELSE "No"
END) as triangle
FROM triangle
